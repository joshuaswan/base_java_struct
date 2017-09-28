package com.joshua.struct.applications;

/**
 * Created by joshua on 2017/9/28.
 */
public class SequentialSearch2 {
    /**
     * Search the unordered array a for x.
     * CAUTION: Object.equals must be overriden for this
     * method to work correctly
     *
     * @return position of x if found; -1 otherwise
     */
    public static int sequentialSearch(Object[] a, Object x) {
        a[a.length - 1] = x; // assume extra position available
        int i;
        for (i = 0; !x.equals(a[i]); i++) ;

        if (i == a.length - 1) return -1;
        else return i;
    }
}
