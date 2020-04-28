package TeamWorkProjects;

import java.util.Comparator;
import java.util.List;

public class Team {
private String creator;
private List<String> users;

    public Team(String creator, List<String> users) {
        this.creator = creator;
        this.users = users;
    }

    public String getCreator() {
        return creator;
    }

    public List<String> getUsers() {
        return users;
    }

    public String toString() {
        return String.format("- %s",creator);
    }
}
