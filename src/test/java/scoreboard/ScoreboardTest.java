package scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scoreboard.model.Game;
import scoreboard.model.Score;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {
    private static final Game MEXICO_GAME = new Game("Mexico", "Canada", LocalDateTime.now(), new Score(0, 5));
    private static final Game SPAIN_GAME = new Game("Spain", "Brazil", LocalDateTime.now(), new Score(10, 2));
    private static final Game GERMANY_GAME = new Game("Germany", "France", LocalDateTime.now(), new Score(2, 2));
    private static final Game URUGUAY_GAME = new Game("Uruguay", "Italy", LocalDateTime.now(), new Score(6, 6));
    private static final Game ARGENTINA_GAME = new Game("Argentina", "Australia", LocalDateTime.now(), new Score(3, 1));
    private static final String HOME_TEAM = "England";
    private static final String AWAY_TEAM = "Spain";
    private Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    void whenStartGameThenReturnGame() {
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);

        assertEquals(HOME_TEAM, game.getHomeTeam());
        assertEquals(AWAY_TEAM, game.getAwayTeam());
    }

    @Test
    void whenUpdateScoreThenReturnUpdatedGame() {
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);
        var homeTeamGoals = 2;
        var awayTeamGoals = 1;
        var score = new Score(homeTeamGoals, awayTeamGoals);

        var updatedGame = scoreboard.updateScore(game, score);

        var updatedScore = updatedGame.getScore();
        assertEquals(homeTeamGoals, updatedScore.getHome());
        assertEquals(awayTeamGoals, updatedScore.getAway());
        assertEquals(HOME_TEAM, updatedGame.getHomeTeam());
        assertEquals(AWAY_TEAM, updatedGame.getAwayTeam());
        assertEquals(game.getStartDateTime(), updatedGame.getStartDateTime());
    }

    @Test
    void whenFinishGameThenRemoveItFromScoreboard() {
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);

        scoreboard.finishGame(game);

        var summary = scoreboard.getSummary();
        assertFalse(summary.contains(game));
    }

    @Test
    void whenFinishAlreadyFinishedGameThenThrowException() {
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);
        scoreboard.finishGame(game);

        assertThrows(IllegalStateException.class, () -> scoreboard.finishGame(game));
    }

    @Test
    void whenUpdateScoreForFinishedGameThenThrowException() {
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);
        scoreboard.finishGame(game);

        assertThrows(IllegalStateException.class, () -> scoreboard.updateScore(game, new Score(0, 0)));
    }

    @Test
    void whenStartGameThenAddItToScoreboard() {
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);

        var summary = scoreboard.getSummary();
        assertEquals(1, summary.size());
        assertTrue(summary.contains(game));
    }

    @Test
    void whenUpdateGameThenUpdateItInScoreboard() {
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);
        var score = new Score(3, 1);

        var updatedGame = scoreboard.updateScore(game, score);

        var summary = scoreboard.getSummary();
        assertEquals(1, summary.size());
        assertTrue(summary.contains(updatedGame));
    }

    @Test
    void whenSummaryThenReturnOrderedResults() {
        var scoreboard = new Scoreboard(getGames());

        var summary = scoreboard.getSummary();

        assertEquals(getExpectedSummary(), summary);
    }

    private List<Game> getGames() {
        return List.of(MEXICO_GAME, SPAIN_GAME, GERMANY_GAME, URUGUAY_GAME, ARGENTINA_GAME);
    }

    private List<Game> getExpectedSummary() {
        return List.of(URUGUAY_GAME, SPAIN_GAME, MEXICO_GAME, ARGENTINA_GAME, GERMANY_GAME);
    }
}