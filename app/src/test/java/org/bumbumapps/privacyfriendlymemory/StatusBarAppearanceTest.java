package org.bumbumapps.privacyfriendlymemory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StatusBarAppearanceTest {

    @Test
    public void darkThemeColorsGetLightIcons() {
        assertFalse(EdgeToEdgeCallbacks.isLightColor(0xFF221F35)); // colorPrimary
        assertFalse(EdgeToEdgeCallbacks.isLightColor(0xFF20242F));
        assertFalse(EdgeToEdgeCallbacks.isLightColor(0xFF000000));
    }

    @Test
    public void lightColorsGetDarkIcons() {
        assertTrue(EdgeToEdgeCallbacks.isLightColor(0xFFFFFFFF));
        assertTrue(EdgeToEdgeCallbacks.isLightColor(0xFFF5F5F5));
        assertTrue(EdgeToEdgeCallbacks.isLightColor(0xFFFFEB3B)); // yellow
    }
}
