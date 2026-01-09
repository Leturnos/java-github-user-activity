import api.ApiConfig;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiConfig apiConfig = new ApiConfig();

        if (args.length == 0) {
            System.out.println(
                    "Welcome to GitHub User Activity, " +
                            "please insert 'github-activity <username>' to use");
        } else {
            if (args[0].equals("github-activity")) {
                apiConfig.setRequest(args[1]);
            } else {
                System.out.println("please insert 'github-activity' before the username");
            }
        }
    }
}