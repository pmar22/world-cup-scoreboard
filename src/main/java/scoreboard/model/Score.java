package scoreboard.model;

import java.util.Objects;

public final class Score implements Comparable<Score> {
    private final int home;
    private final int away;

    public Score(int home, int away) {
        if (home < 0 || away < 0) {
            throw new IllegalArgumentException("Score cannot be below zero. Provided home: " + home + " away: " + away);
        }
        this.home = home;
        this.away = away;
    }

    public int getHome() {
        return home;
    }

    public int getAway() {
        return away;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return home == score.home && away == score.away;
    }

    @Override
    public int hashCode() {
        return Objects.hash(home, away);
    }

    @Override
    public String toString() {
        return "Score: " + home + " " + away;
    }

    @Override
    public int compareTo(Score score) {
        return Integer.compare(this.away + this.home, score.away + score.home);
    }
}
