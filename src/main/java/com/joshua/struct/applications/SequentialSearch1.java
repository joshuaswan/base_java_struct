package com.joshua.struct.applications;

/**
 * Created by joshua on 2017/9/28.
 */
public class SequentialSearch1 {
    /**
     * Search the unordered array a for x.
     * CAUTION: Object.equals must be overriden for this method to work correctly
     *
     * @return position of x if found; -1 otherwise
     */
    public static int sequentialSearch(Object[] a, Object x) {
        int i;
        for (i = 0; i < a.length && !x.equals(a[i]); i++) ;
        if (i == a.length)
            return -1;
        else
            return i;
    }
}
