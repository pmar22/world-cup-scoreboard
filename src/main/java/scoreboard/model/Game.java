package scoreboard.model;

import java.util.Objects;

public final class Game {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam) && Objects.equals(score, game.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, score);
    }
}
