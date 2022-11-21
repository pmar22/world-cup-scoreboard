package scoreboard;

public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private final Score score;

    Game(String homeTeam, String awayTeam) {
        this(homeTeam, awayTeam, new Score(0, 0));
    }

    public Game(String homeTeam, String awayTeam, Score score) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    String getHomeTeam() {
        return homeTeam;
    }

    String getAwayTeam() {
        return awayTeam;
    }

    Score getScore() {
        return score;
    }
}
