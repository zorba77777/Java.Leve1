package lesson9;

import lesson9.obstacles.Cross;
import lesson9.obstacles.Obstacle;
import lesson9.obstacles.Wall;
import lesson9.obstacles.Water;
import lesson9.team.Competition;
import lesson9.team.Team;

public class MainClass {

    public static void main(String[] args) {
        Team[] competition1 = {
                new Competition("Саша", 5000, 500, 5),
                new Competition("Миша", 3000, 300, 3)
        };
        Team[] competition2 = {
                new Competition("Вася", 5500, 200, 7),
                new Competition("Женя", 3500, 600, 5)
        };

        Team teamOrange = new Team(
                "Апельсины",
                "Апельсинов ждет успех\n" + "Апельсины - лучше всех!",
                competition1
        );

        Team teamApple = new Team(
                "Яблоки",
                "яблоков ждет успех\n" + "Яблоки - лучше всех!",
                competition2
        );

        Team[] teams = {teamOrange, teamApple};

        Obstacle[] obstacles = {
                new Cross(3000),
                new Wall(5),
                new Water(100),
                new Cross(3000)
        };

        for (Team currentTeam : teams) {
            currentTeam.motto();
            for (Team competitor : currentTeam.competition) {
                for (Obstacle obstacle : obstacles) {
                    obstacle.doIt(competitor);
                    if (!competitor.isOnDistance()) break;
                }
            }
        }

        for (Team currentTeam : teams) {
            for (Team competitor : currentTeam.competition) {
                if (competitor.isOnDistance()) {
                    System.out.println(competitor.getName() + " - прошел дистанцию");
                } else {
                    System.out.println(competitor.getName() + " - не прошел дистанцию");
                }
            }
        }
    }
}

