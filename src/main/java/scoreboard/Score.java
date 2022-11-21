package scoreboard;

public class Score {
    private final int home;
    private final int away;

    public Score(int home, int away) {
        this.home = home;
        this.away = away;
    }

    public int getHome() {
        return home;
    }

    public int getAway() {
        return away;
    }
}
