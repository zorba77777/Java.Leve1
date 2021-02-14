package lesson9.obstacles;

import lesson9.team.Team;

public class Water extends  Obstacle {

    int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Team team) {
        team.swim(distance);
    }
}
