package org.bumbumapps.privacyfriendlymemory.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hannes on 31.05.2016.
 */
public class MemoGameHighscore {

    private static Map<MemoGameDifficulty, Integer> baseScoreMapping = new HashMap<>();
    private final int baseScore;
    private final int time;
    private final int tries;
    private final boolean isValid;

    static {
        baseScoreMapping.put(MemoGameDifficulty.Level1, 3000);
        baseScoreMapping.put(MemoGameDifficulty.Level2, 5000);
        baseScoreMapping.put(MemoGameDifficulty.Level3, 7000);
        baseScoreMapping.put(MemoGameDifficulty.Level4, 9000);
        baseScoreMapping.put(MemoGameDifficulty.Level5, 10000);
        baseScoreMapping.put(MemoGameDifficulty.Level6, 12000);
        baseScoreMapping.put(MemoGameDifficulty.Level7, 14000);
        baseScoreMapping.put(MemoGameDifficulty.Level8, 16000);
        baseScoreMapping.put(MemoGameDifficulty.Level9, 18000);
        baseScoreMapping.put(MemoGameDifficulty.Level10, 20000);
        baseScoreMapping.put(MemoGameDifficulty.Level11, 22000);
        baseScoreMapping.put(MemoGameDifficulty.Level12, 24000);
        baseScoreMapping.put(MemoGameDifficulty.Level13, 26000);
        baseScoreMapping.put(MemoGameDifficulty.Level14, 28000);
        baseScoreMapping.put(MemoGameDifficulty.Level15, 30000);
        baseScoreMapping.put(MemoGameDifficulty.Level16, 32000);
        baseScoreMapping.put(MemoGameDifficulty.Level17, 36000);
        baseScoreMapping.put(MemoGameDifficulty.Level18, 38000);
        baseScoreMapping.put(MemoGameDifficulty.Level19, 40000);
        baseScoreMapping.put(MemoGameDifficulty.Level20, 42000);
        baseScoreMapping.put(MemoGameDifficulty.Level21, 44000);
        baseScoreMapping.put(MemoGameDifficulty.Level22, 46000);
        baseScoreMapping.put(MemoGameDifficulty.Level23, 48000);
        baseScoreMapping.put(MemoGameDifficulty.Level24, 50000);

    }

    public MemoGameHighscore(MemoGameDifficulty difficulty, int time, int tries, boolean isValid) {
        this.baseScore = baseScoreMapping.get(difficulty);
        this.time = time;
        this.tries = tries;
        this.isValid = isValid;
    }

    public int getScore() {
        int calculatedScore = baseScore - (time * tries);
        // score should not be negative
        return calculatedScore < 0 ? 0 : calculatedScore;
    }

    public int getTries() {
        return tries;
    }

    public int getTime() {
        return time;
    }

    public boolean isValid() { return isValid; }

}
