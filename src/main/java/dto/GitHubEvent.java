package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubEvent {
    private String type;
    private Repo repo;

    public GitHubEvent(){}

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GitHubEvent that = (GitHubEvent) o;
        return Objects.equals(getType(), that.getType()) && Objects.equals(getRepo(), that.getRepo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getRepo());
    }
}
