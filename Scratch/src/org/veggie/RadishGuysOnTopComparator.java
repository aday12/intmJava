package org.veggie;

import java.util.Comparator;

//sort key is guysOnTop
class RadishGuysOnTopComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish r1, Radish r2) {
        return Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop()); // type Integer because int doesn't have compareTo()
    }
}
