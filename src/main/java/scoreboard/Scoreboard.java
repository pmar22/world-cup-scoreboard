package scoreboard;

import scoreboard.model.Game;
import scoreboard.model.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {
    private final List<Game> ongoingGames;

    public Scoreboard(List<Game> ongoingGames) {
        this.ongoingGames = new ArrayList<>(ongoingGames);
    }

    public Scoreboard() {
        this(new ArrayList<>());
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
        var updatedGame = new Game(game.getHomeTeam(), game.getAwayTeam(), game.getStartDateTime(), score);
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
        var summary = new ArrayList<>(ongoingGames);
        var comparator = Comparator
                .comparing(Game::getScore)
                .thenComparing(Game::getStartDateTime)
                .reversed();
        summary.sort(comparator);
        return summary;
    }
}
