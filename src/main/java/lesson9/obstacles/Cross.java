package lesson9.obstacles;

import lesson9.team.Team;

public class Cross extends Obstacle {

    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Team team) {
        team.run(length);
    }
}
