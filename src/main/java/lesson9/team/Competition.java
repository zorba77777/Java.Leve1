package lesson9.team;

public class Competition extends Team {

    public Competition(String teamName, String motto, Team[] competition) {
        super(teamName, motto, competition);
    }

    public Competition(String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        super(name, maxRunDistance, maxSwimDistance, maxJumpHeight);
    }
}
