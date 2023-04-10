package org.bumbumapps.privacyfriendlymemory.model;

import android.support.annotation.StringRes;

import org.bumbumapps.privacyfriendlymemory.ui.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hannes on 19.05.2016.
 */
public enum MemoGameDifficulty {


    Level1(R.string.level1, 16),
    Level2(R.string.level2, 18),
    Level3(R.string.level3, 20),
    Level4(R.string.level4, 22),
    Level5(R.string.level5, 24),
    Level6(R.string.level6, 26),
    Level7(R.string.level7, 28),
    Level8(R.string.level8, 30),
    Level9(R.string.level9, 32),
    Level10(R.string.level10, 34),
    Level11(R.string.level11, 36),
    Level12(R.string.level12, 38),
    Level13(R.string.level13, 40),
    Level14(R.string.level14, 42),
    Level15(R.string.level15, 44),
    Level16(R.string.level16, 46),
    Level17(R.string.level17, 48),
    Level18(R.string.level18, 50),
    Level19(R.string.level19, 52),
    Level20(R.string.level20, 54),
    Level21(R.string.level21, 56),
    Level22(R.string.level22, 60),
    Level23(R.string.level23, 62),
    Level24(R.string.level24, 64);

    private final int resID;
    private final int deckSize;

    private static List<MemoGameDifficulty> validDifficulties = new LinkedList<>();

    static{
        validDifficulties.add(Level1);
        validDifficulties.add(Level2);
        validDifficulties.add(Level3);
        validDifficulties.add(Level4);
        validDifficulties.add(Level5);
        validDifficulties.add(Level6);
        validDifficulties.add(Level7);
        validDifficulties.add(Level8);
        validDifficulties.add(Level9);
        validDifficulties.add(Level10);
        validDifficulties.add(Level11);
        validDifficulties.add(Level12);
        validDifficulties.add(Level13);
        validDifficulties.add(Level14);
        validDifficulties.add(Level15);
        validDifficulties.add(Level16);
        validDifficulties.add(Level17);
        validDifficulties.add(Level18);
        validDifficulties.add(Level19);
        validDifficulties.add(Level20);
        validDifficulties.add(Level21);
        validDifficulties.add(Level22);
        validDifficulties.add(Level23);
        validDifficulties.add(Level24);
    }


    MemoGameDifficulty(@StringRes int resID, int deckSize) {
        this.resID = resID;
        this.deckSize = deckSize;
    }

    public int getStringResID() {
        return resID;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public static List<MemoGameDifficulty> getValidDifficulties(){
        return validDifficulties;
    }

}
