package com.joshua.struct.applications;

import com.joshua.struct.utilities.MyMath;

/**
 * Created by joshua on 2017/9/27.
 */
public class RankSort2 {
    /** sort the array a using the rank sort method */
    public static void rankSort(Comparable [] a)
    {
        // create rank array
        int [] r = new int [a.length];

        // rank the elements
        Rank.rank(a, r);

        // rearrange into sorted order
        rearrange(a, r);
    }

    /** rearrange objects by rank
     * @param a is the object array
     * @param r is the rank array */
    private static void rearrange(Comparable [] a, int [] r)
    {// In-place rearrangement into sorted order.
        for (int i = 0; i < a.length; i++)
            // get proper element reference to a[i]
            while (r[i] != i)
            {
                int t = r[i];
                MyMath.swap(a, i, t);
                MyMath.swap(r, i, t);
            }
    }
}
