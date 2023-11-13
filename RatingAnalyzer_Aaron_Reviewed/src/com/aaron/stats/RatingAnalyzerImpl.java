package com.aaron.stats;

import org.stats.AnalyzerConfigurationException;
import org.stats.RatingAnalyzer;

import java.util.*;

/**
 * JR: Very good result overall.
 * No test for null input ratings.  Test class name is incorrect.
 *
 * Also check for comments below and in test class.
 */
public class RatingAnalyzerImpl implements RatingAnalyzer {
    //fields
    private int[] ratings;

    //ctor
    // JR: unnecessary - if you provide only the ctor below, that is the only ctor this class has.
    private RatingAnalyzerImpl() {
    }

    public RatingAnalyzerImpl(int[] ratings) throws IllegalArgumentException {
        if (ratings == null || ratings.length == 0) {
            throw new IllegalArgumentException("Must input valid arguments");
        } else {
            this.ratings = ratings;
        }
    }

    //methods
    @Override
    public double mean() throws IllegalArgumentException {

        double sum = 0.0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum / ratings.length;
    }

    @Override
    public double median() throws IllegalArgumentException {
        Arrays.sort(ratings);
        int mid = ratings.length / 2;

        if (ratings.length % 2 != 0) {
            return ratings[(int) mid];
        } else {
            int mid2 = (ratings.length / 2) - 1;
            return ((double) ((ratings[mid2] + ratings[mid])) / 2);
        }
    }


    @Override
    public int[] mode() throws IllegalArgumentException {
        Map<Integer, Integer> ratingsMap = new HashMap<>();
        int maxOccurrences = 0;

        for (int rating : ratings) {    // find max
            int count = ratingsMap.getOrDefault(rating, 0) + 1;
            ratingsMap.put(rating, count);
            maxOccurrences = Math.max(maxOccurrences, count);
        }

        List<Integer> modeList = new ArrayList<>();

        for (int rating : ratingsMap.keySet()) {
            if (ratingsMap.get(rating) == maxOccurrences) {
                modeList.add(rating);
            }
        }

        int[] mode = new int[modeList.size()];
        for (int i = 0; i < modeList.size(); i++) {
            mode[i] = modeList.get(i);
        }
        Arrays.sort(mode);
        return mode;
    }
}