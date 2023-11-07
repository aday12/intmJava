package com.javatunes.billing;

public class TaxCalculatorFactory {

    private TaxCalculatorFactory(){
    }

    public static TaxCalculator getTaxCalc(Location location) {
        TaxCalculator calc = null;

        /*
         * TODO: Consider implementing cache of taxcalc objs
         *
         * if i have not previously created the obj then
         * ill create it here add it to my cache then return it
         *
         * if its already in cache ill fetch it from there and return it
         *
         * Hint can use a simple Map<Location, TaxCalc> for the cache
         */
        switch (location){
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
                break;
        }
        return calc;
    }
}
