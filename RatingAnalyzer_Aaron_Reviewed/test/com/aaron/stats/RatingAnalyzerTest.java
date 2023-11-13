package com.aaron.stats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.stats.AnalyzerConfigurationException;
import org.stats.RatingAnalyzer;
import org.stats.RatingAnalyzer.*;

import java.sql.Date;
import java.util.Arrays;


public class RatingAnalyzerTest {

    private int[] ratings = {1, 3, 5, 3};
    private int[] ratingsN = {};
    private int[] ratingsEven = {1, 5, 3, 3, 4, 5};
    private int[] ratingsOdd = {1, 5, 3, 3, 3};
    private int[] ratingsM1 = {1, 5, 3, 23, 5};
    private int[] ratingsM2 = {1, 5, 3};
    private RatingAnalyzer analyzer;


    @Test
    public void mean_shouldReturnMean() {
        analyzer = RatingAnalyzer.newInstance(ratings);
        assertEquals(3, analyzer.mean(), .001);
    }

    @Test
    public void median_shouldReturnMedian_evenNumSet() {
        analyzer = RatingAnalyzer.newInstance(ratingsEven);
        assertEquals(3.5, analyzer.median(), .001);
    }

    @Test
    public void median_shouldReturnMedian_ofOddNumberSet() {
        analyzer = RatingAnalyzer.newInstance(ratingsOdd);
        assertEquals(3, analyzer.median(), .001);
    }

    /*
     * JR: to be 100% sure of correct behavior here, you need to check two things:
     *  1. AnalyzerConfigurationException is thrown from RatingAnalyzer.newInstance().
     *  2. The nested exception inside is an instance of IllegalArgumentException.
     * See first two test methods (prefixed with "constructor_") in my test class,
     * com.jrostosk.stats.RatingAnalyzerImplTest.
     *
     * Also, you are instantiating your impl class directly via "new" which is disallowed.
     * Instead, call RatingAnalyzer.newInstance() as per spec.
     */
    @Test(expected = IllegalArgumentException.class)
    public void newInstance_shouldThrowIllegalArgException() throws IllegalArgumentException {
        RatingAnalyzer analyzer = new RatingAnalyzerImpl(ratingsN);
    }

    @Test
    public void mode_shouldMostCommonNum_whenOneMode() {
        analyzer = RatingAnalyzer.newInstance(ratingsM1);
        assertArrayEquals(new int[]{5}, analyzer.mode());
        System.out.println(Arrays.toString(analyzer.mode()));
    }

    @Test
    public void mode_shouldReturnAllNums_whenMultipleModes() {
        analyzer = RatingAnalyzer.newInstance(ratingsM2);
        assertArrayEquals(new int[]{1, 3, 5}, analyzer.mode());
    }
}