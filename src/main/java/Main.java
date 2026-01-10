import api.ApiConfig;
import util.CliFormatter;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(
                    "Welcome to GitHub User Activity, " +
                            "please insert 'github-activity <username>' to use");
        } else {
            if (args[0].equals("github-activity") && args.length == 2) {
                try {
                    HttpResponse<String> response = ApiConfig.setRequest(args[1]);
                    CliFormatter.formatResponse(response);
                } catch (RuntimeException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error occurred.");
                }
            } else {
                System.out.println("please insert 'github-activity <username>' to use");
            }
        }
    }
}