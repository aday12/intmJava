package com.entertainment;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television("Sony", 1, DisplayType.OLED);
        tv2 = new Television("Sony", 1, DisplayType.OLED);

    }

    @Test
    public void hashCode_shouldBeTrue() {
        assertEquals(tv.hashCode(), tv2.hashCode());
    }

    @Test
    public void compareTo() {
        assertEquals(0, tv.getBrand().compareTo(tv2.getBrand()));
    }

    @Test
    public void equals_shouldReturnFalse_whenVolumeNotEqual() {
       tv.setVolume(12);
        assertNotEquals(tv.getVolume(), tv2.getVolume());
    }

    @Test
    public void equals_shouldReturnFalse_whenBrandNotEqual() {
        tv2.setBrand("LG");
        assertNotEquals(tv.getBrand(), tv2.getBrand());
    }

    @Test
    public void equals_shouldReturnTrue_whenEqual() {
        tv = new Television("Sony", 1, DisplayType.OLED);
        tv2 = new Television("Sony", 1, DisplayType.OLED);
        assertEquals(tv, tv2);
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test(expected=InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(0);
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        try {
            tv.setVolume(101); //should trigger the exception
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            String expected = "Invalid volume: 101. Allowed range: [0,100].";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1); //should trigger the exception
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBand() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }
}