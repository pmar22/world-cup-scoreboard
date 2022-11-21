package scoreboard.model;

public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private final Score score;

    public Game(String homeTeam, String awayTeam) {
        this(homeTeam, awayTeam, new Score(0, 0));
    }

    public Game(String homeTeam, String awayTeam, Score score) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Score getScore() {
        return score;
    }
}
