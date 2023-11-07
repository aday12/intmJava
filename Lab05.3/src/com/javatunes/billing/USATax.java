/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * Domestic orders have a graduated tax scheme:
 * The first $20.00 is tax-free.
 * Amount over $20.00 is taxed at 10.0%.
 *
 * TODO: implement this algorithm.
 */
public class USATax implements TaxCalculator{

    @Override
    public double taxAmount(double taxable) {
        final double taxRate = .1;
        final double taxThreshold = 20.0;

        double result = 0.0;


        //either implementation is correct
        if (taxable > taxThreshold) {
            result += (taxable - taxThreshold) * taxRate;
        }
        return result;

        /*
         * replace all 20's with taxThreshold
        if (taxable < 20){
            return 0;
        }
        else{
            return (taxable - 20) * .1;
        }

         */
    }
}