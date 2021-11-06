package Model;

public class Score {
    private int score;
    private static int highScore;

    /**
     * Default constructor for Score class
     */
    public Score()
    {
        score = 0;
        highScore = 0;
    }

    public void addScore(int scoreValue)
    {
        score += scoreValue;
    }

    public void updateScore(int scoreValue)
    {
        score = scoreValue;
    }

    public void updateHighScore()
    {
        if(score > highScore)
        {
            highScore = score;
        }
    }

    public int getScore()
    {
        return score;
    }

    public int getHighScore()
    {
        return highScore;
    }
}