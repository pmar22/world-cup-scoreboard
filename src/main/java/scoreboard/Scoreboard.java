package scoreboard;

public class Scoreboard {
    public Game startGame(String homeTeam, String awayTeam) {
        return new Game(homeTeam, awayTeam);
    }

    public Game updateScore(Game game, Score score) {
        return new Game(game.getHomeTeam(), game.getAwayTeam(), score);
    }
}
