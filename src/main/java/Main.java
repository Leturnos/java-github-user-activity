import api.ApiConfig;
import util.CliFormatter;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length == 0) {
            System.out.println(
                    "Welcome to GitHub User Activity, " +
                            "please insert 'github-activity <username>' to use");
        } else {
            if (args[0].equals("github-activity")) {
                HttpResponse<String> response = ApiConfig.setRequest(args[1]);
                CliFormatter.formatResponse(response);
            } else {
                System.out.println("please insert 'github-activity' before the username");
            }
        }
    }
}