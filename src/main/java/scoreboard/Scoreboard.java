package scoreboard;

import scoreboard.model.Game;
import scoreboard.model.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scoreboard {
    private final List<Game> ongoingGames;

    public Scoreboard() {
        this.ongoingGames = new ArrayList<>();
    }

    public Game startGame(String homeTeam, String awayTeam) {
        var game = new Game(homeTeam, awayTeam);
        ongoingGames.add(game);
        return game;
    }

    public Game updateScore(Game game, Score score) {
        if (!ongoingGames.contains(game)) {
            throw new IllegalStateException("Game is not in progress now");
        }
        var updatedGame = new Game(game.getHomeTeam(), game.getAwayTeam(), score);
        ongoingGames.remove(game);
        ongoingGames.add(updatedGame);
        return updatedGame;
    }

    public void finishGame(Game game) {
        if (!ongoingGames.contains(game)) {
            throw new IllegalStateException("Game is not in progress now");
        }
        ongoingGames.remove(game);
    }

    public List<Game> getSummary() {
        return Collections.unmodifiableList(ongoingGames);
    }
}
