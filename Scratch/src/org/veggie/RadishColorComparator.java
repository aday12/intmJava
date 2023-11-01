package org.veggie;

import java.util.Comparator;

//sort key is color
class RadishColorComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish r1, Radish r2) {
        return r1.getColor().compareTo(r2.getColor());
    }
}
