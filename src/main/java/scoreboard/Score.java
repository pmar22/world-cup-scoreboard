package scoreboard;

public class Score {
    private final int homeTeamGoals;
    private final int awayTeamGoals;

    public Score(int homeTeamGoals, int awayTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }
}
