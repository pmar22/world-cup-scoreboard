package scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {
    private static final String HOME_TEAM = "England";
    private static final String AWAY_TEAM = "Spain";

    @Test
    void whenStartGameThenReturnGame() {
        var scoreboard = new Scoreboard();

        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);

        assertEquals(HOME_TEAM, game.getHomeTeam());
        assertEquals(AWAY_TEAM, game.getAwayTeam());
    }

    @Test
    void whenUpdateScoreThenReturnUpdatedGame() {
        var scoreboard = new Scoreboard();
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);
        var homeTeamGoals = 2;
        var awayTeamGoals = 1;
        var score = new Score(homeTeamGoals, awayTeamGoals);

        Game updatedGame = scoreboard.updateScore(game, score);

        var updatedScore = updatedGame.getScore();
        assertEquals(homeTeamGoals, updatedScore.getHomeTeamGoals());
        assertEquals(awayTeamGoals, updatedScore.getAwayTeamGoals());
        assertEquals(HOME_TEAM, updatedGame.getHomeTeam());
        assertEquals(AWAY_TEAM, updatedGame.getAwayTeam());
    }

    @Test
    void whenFinishGameThenRemoveItFromScoreboard() {
        var scoreboard = new Scoreboard();
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);

        scoreboard.finishGame(game);

        var summary = scoreboard.getSummary();
        assertFalse(summary.contains(game));
    }

    @Test
    void whenFinishAlreadyFinishedGameThenThrowException() {
        var scoreboard = new Scoreboard();
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);

        scoreboard.finishGame(game);
        assertThrows(IllegalStateException.class, () -> scoreboard.finishGame(game));
    }

    @Test
    void whenUpdateScoreForFinishedGameThenThrowException() {
        var scoreboard = new Scoreboard();
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);
        scoreboard.finishGame(game);

        assertThrows(IllegalStateException.class, () -> scoreboard.updateScore(game, new Score(0, 0)));
    }
}