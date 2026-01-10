package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.GitHubEvent;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class CliFormatter {
    public static void formatResponse (HttpResponse<String> response) throws IOException {
        System.out.println("Output:");

        ObjectMapper mapper = new ObjectMapper();
        List<GitHubEvent> events = mapper.readValue(response.body(), new TypeReference<List<GitHubEvent>>() {});

        for (GitHubEvent event:events) {
            switch (event.getType()) {
                case "PushEvent" ->
                        System.out.println("- Pushed commits to " + event.getRepo().getName());

                case "CreateEvent" ->
                        System.out.println("- Created " + event.getPayload().getRefType() +
                                " " + event.getPayload().getRef() +
                                " in " + event.getRepo().getName());

                case "IssueCommentEvent" ->
                        System.out.println();

                case "IssuesEvent" ->
                        System.out.println();

                case "PullRequestEvent" ->
                        System.out.println();

                case "WatchEvent" ->
                        System.out.println();

                case "PullRequestReviewEvent" ->
                        System.out.println();

                case "PullRequestReviewCommentEvent" ->
                        System.out.println();

                default -> {}
            }
        };
    }
}
