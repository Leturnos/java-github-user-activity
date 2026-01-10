package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConfig {
    public static HttpResponse<String> setRequest (String username) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/" + username + "/events"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            throw new RuntimeException("User not found, please check your username");
        }
        if (response.statusCode() == 403) {
            throw new RuntimeException("GitHub API rate limit exceeded, please try again later");
        }

        return  response;
    }
}



