package scoreboard;

public class Game {
    private final String homeTeam;
    private final String awayTeam;

    Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    String getHomeTeam() {
        return homeTeam;
    }

    String getAwayTeam() {
        return awayTeam;
    }

    int getHomeTeamGoals() {
        return 0;
    }

    int getAwayTeamGoals() {
        return 0;
    }
}
