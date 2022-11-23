package scoreboard.model;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

public final class Game implements Comparable<Game> {
    private final String homeTeam;
    private final String awayTeam;
    private final Score score;
    private final LocalDateTime startDateTime;

    public Game(String homeTeam, String awayTeam) {
        this(homeTeam, awayTeam, new Score(0, 0));
    }

    public Game(String homeTeam, String awayTeam, Score score) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.startDateTime = LocalDateTime.now();
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
        return Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam) && Objects.equals(score, game.score) && Objects.equals(startDateTime, game.startDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, score, startDateTime);
    }

    @Override
    public String toString() {
        return homeTeam + " " + score.getHome() + " - " + awayTeam + " " + score.getAway();
    }

    @Override
    public int compareTo(Game game) {
        return Comparator
                .comparing(Game::getScore)
                .thenComparing(g -> g.startDateTime)
                .reversed()
                .compare(this, game);
    }
}
