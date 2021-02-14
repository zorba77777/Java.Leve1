package lesson9.obstacles;

import lesson9.team.Team;

public class Wall extends Obstacle {

    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Team team) {
        team.jump(height);
    }
}
