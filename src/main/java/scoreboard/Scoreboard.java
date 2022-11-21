package scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private final List<Game> finishedGames = new ArrayList<>();

    public Game startGame(String homeTeam, String awayTeam) {
        return new Game(homeTeam, awayTeam);
    }

    public Game updateScore(Game game, Score score) {
        if (finishedGames.contains(game)) {
            throw new IllegalStateException("Game has been already finished");
        }
        return new Game(game.getHomeTeam(), game.getAwayTeam(), score);
    }

    public void finishGame(Game game) {
        if (finishedGames.contains(game)) {
            throw new IllegalStateException("Game has been already finished");
        }
        finishedGames.add(game);
    }

    public List<Game> getSummary() {
        return new ArrayList<>();
    }
}
