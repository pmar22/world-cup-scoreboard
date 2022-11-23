# world-cup-scoreboard

Liibrary providing Live World Cup Scoreboard

Class Scoreboard provides methods:
- startGame - starts games and adds it to the scoreboard
- updateScore - updates score for a game or throws exception when the game is not in progress
- finishGame - finishes a game (removes from scoreboard) or throws exception when the game is not in progress
- getSummary - returns actual snapshot of ongoing games results. Subsequent game changes will not be reflected in the returned list.

Additional assumption:
- score should not be below 0
- Scoreboard is not thread-safe class