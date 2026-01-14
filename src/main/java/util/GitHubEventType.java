package util;

public enum GitHubEventType {
    PUSH_EVENT("PushEvent"),
    CREATE_EVENT("CreateEvent"),
    ISSUE_COMMENT_EVENT("IssueCommentEvent"),
    ISSUES_EVENT("IssuesEvent"),
    PULL_REQUEST_EVENT("PullRequestEvent"),
    WATCH_EVENT("WatchEvent"),
    PULL_REQUEST_REVIEW_EVENT("PullRequestReviewEvent"),
    PULL_REQUEST_REVIEW_COMMENT_EVENT("PullRequestReviewCommentEvent"),
    UNKNOWN("Unknown");

    private final String type;

    GitHubEventType(String type) {
        this.type = type;
    }

    // String -> Enum
    public static GitHubEventType fromApi(String apiName) {
        for (GitHubEventType type : values()) {
            if (type.type.equals(apiName)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
