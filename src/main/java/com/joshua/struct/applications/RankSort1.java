package com.joshua.struct.applications;

/**
 * Created by joshua on 2017/9/27.
 */
public class RankSort1 {
    /**
     * sort the array a using the rank sort method
     */
    public static void rankSort(Comparable[] a) {
        // create rank array
        int[] r = new int[a.length];

        // rank the elements
        Rank.rank(a, r);

        // rearrange into sorted order
        rearrange(a, r);
    }

    /**
     * rearrange objects by rank using an additional array
     *
     * @param a is the object array
     * @param r is the rank array
     */
    private static void rearrange(Comparable[] a, int[] r) {
        // create an additional array u
        Comparable[] u = new Comparable[a.length];

        // move references to correct place in u
        for (int i = 0; i < a.length; i++)
            u[r[i]] = a[i];

        // move back to a
        for (int i = 0; i < a.length; i++)
            a[i] = u[i];
    }


}
