package scoreboard;

public class Scoreboard {
    public Game startGame(String homeTeam, String awayTeam) {
        return new Game(homeTeam, awayTeam);
    }

}
