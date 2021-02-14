package lesson9.team;

public class Team {

    public Team[] competition;

    String teamName;
    String motto;
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeight;
    boolean onDistance;

    public String getName() {
        return name;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public Team(String teamName, String motto, Team[] competition) {
        this.teamName = teamName;
        this.motto = motto;
        this.competition = competition;
    }

    public Team(String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public void motto() {
        System.out.println("На полосу препядствий врывается команда " + teamName + ". Их девиз: \n" + motto);
    }
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " успешно справился с кроссом");
        } else {
            System.out.println(name + " не смог преодолеть кросс. " + name + " выбывает из игры");
            onDistance = false;
        }
    }

    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " успешно перепрыгнул препядствие");
        } else {
            System.out.println(name + " не смог перепрыгнуть препядствие. " + name + " выбывает из игры");
            onDistance = false;
        }

    }

    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(name + " успешно проплыл дистанцию");
        } else {
            System.out.println(name + " не смог проплыть дистанцию. " + name + " выбывает из игры");
            onDistance = false;
        }
    }
}