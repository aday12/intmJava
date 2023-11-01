package com.entertainment;

import java.util.Comparator;

class TelevisionBrandChannelComparator implements Comparator<Television> {
    public int compare(Television tv1, Television tv2) {
        int result = tv1.getBrand().compareTo(tv2.getBrand());

        if (tv1.getBrand().equals(tv2.getBrand())) {
            Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
        }
        return result;
    }
}
