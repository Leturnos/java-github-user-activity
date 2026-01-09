package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConfig {
    HttpClient client = HttpClient.newHttpClient();

    public void setRequest (String username) throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/" + username + "/events"))
            .GET()
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println("Status: " + response.statusCode());
    System.out.println("Body:");
    System.out.println(response.body());
    }
}

