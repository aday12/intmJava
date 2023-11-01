package com.entertainment;

import java.util.Comparator;
import com.entertainment.Television;

public class TelevisionChannelComparator implements Comparator<Television> {

    public int compare(Television tv1, Television tv2) {
        return Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
    }
}
