package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.GitHubEvent;

import java.net.http.HttpResponse;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CliFormatter {
    public static List<GitHubEvent> transformToList(HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<GitHubEvent>>() {});
    }

    public static void printFormattedResponse (HttpResponse<String> response) throws JsonProcessingException {
        List<GitHubEvent> events = transformToList(response);

        System.out.println("Output:");

        Map<String, Map<GitHubEventType, Integer>> repoActivity = new LinkedHashMap<>();

        for (GitHubEvent event:events) {
            String repoName = event.getRepo().getName();
            GitHubEventType type = GitHubEventType.fromApi(event.getType());

            repoActivity.putIfAbsent(repoName, new EnumMap<>(GitHubEventType.class));
            Map<GitHubEventType, Integer> eventCounts = repoActivity.get(repoName);

            eventCounts.put(type, eventCounts.getOrDefault(type, 0) + 1);
        }

        repoActivity.forEach((repoName, activities) -> {
            activities.forEach((type, count) -> {
                switch (type) {
                    case PUSH_EVENT ->
                            System.out.println("- Pushed " + count + " commit(s) to " + repoName);
                    case WATCH_EVENT ->
                            System.out.println("- Starred " + repoName);
                    case CREATE_EVENT ->
                            System.out.println("- Created " + count + " resource(s) in " + repoName);
                    case ISSUES_EVENT ->
                            System.out.println("- Opened " + count + " issue(s) in " + repoName);
                    default ->
                            System.out.println("- " + type.name() + ": " + count + " event(s) in " + repoName);
                }
            });
        });
    };
}

