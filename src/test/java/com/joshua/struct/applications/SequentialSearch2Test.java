package com.joshua.struct.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/9/28.
 */
public class SequentialSearch2Test {
    @Test
    public void sequentialSearch() throws Exception {
        Integer[] a = {new Integer(0),
                new Integer(5),
                new Integer(3),
                new Integer(4),
                new Integer(7),
                new Integer(2),
                new Integer(6),
                null};  // dummy
        Integer x = new Integer(20);

        for (int i = 0; i < a.length; i++) {// search for x
            int j = SequentialSearch2.sequentialSearch(a, x);
            if (j < 0)
                System.out.println(x + " is not in the array");
            else
                System.out.println("a[" + j + "] = " + x);
            // look for next array object
            if (i < a.length) x = a[i];
        }
    }

}