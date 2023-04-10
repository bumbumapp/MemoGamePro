package org.bumbumapps.privacyfriendlymemory;

import org.junit.Before;
import org.junit.Test;
import org.bumbumapps.privacyfriendlymemory.model.CardDesign;
import org.bumbumapps.privacyfriendlymemory.model.MemoGame;
import org.bumbumapps.privacyfriendlymemory.model.MemoGameDifficulty;
import org.bumbumapps.privacyfriendlymemory.model.MemoGameMode;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Hannes on 29.05.2016.
 */
public class MemoryTest {

    private MemoGame memory;

    @Before
    public void setUp(){
        this.memory = new MemoGame(CardDesign.FIRST, MemoGameMode.ONE_PLAYER, MemoGameDifficulty.Easy);
    }

    @Test
    public void testMemorySovlable(){
            for (int i = 0; i <= memory.getDifficulty().getDeckSize() - 1; i++) {
                for (int j = 1; j <= memory.getDifficulty().getDeckSize() - 1; j++) {
                    if(i != j) {
                        memory.select(i);
                        memory.select(j);
                    }
                }
        }
        assertTrue("Memory should be solved!", memory.isFinished());
    }
}
