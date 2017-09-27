package com.joshua.struct.applications;

/**
 * Created by joshua on 2017/9/12.
 */
public class Rank {
    /**
     * @param a is the array of objects to be ranked
     * @param r is the array of computed ranks
     * @throws IllegalArgumentException when the length of r is smaller than that of a
     */
    public static void rank(Comparable[] a, int[] r) {// Rank the objects in a[].
        // make sure rank array is large enough
        if (r.length < a.length)
            throw new IllegalArgumentException
                    ("length of rank array cannot " +
                            "be less than the number of objects");

        // set all ranks to zero
        for (int i = 0; i < a.length; i++)
            r[i] = 0;

        // compare all pairs of objects
        for (int i = 1; i < a.length; i++)
            for (int j = 0; j < i; j++)
                if (a[j].compareTo(a[i]) <= 0) r[i]++;
                else r[j]++;
    }
}
