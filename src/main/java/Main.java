import api.ApiConfig;
import util.CliFormatter;

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    "Welcome to GitHub User Activity, " +
                            "please insert 'github-activity <username>' to use");
        } else {
            try {
                HttpResponse<String> response = ApiConfig.setRequest(args[0]);
                CliFormatter.printFormattedResponse(response);
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred.");
            }
        }
    }
}
