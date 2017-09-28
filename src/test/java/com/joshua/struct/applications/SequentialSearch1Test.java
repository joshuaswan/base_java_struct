package com.joshua.struct.applications;

import com.joshua.struct.wrappers.MyInteger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/9/28.
 */
public class SequentialSearch1Test {
    @Test
    public void sequentialSearch() throws Exception {
        MyInteger[] a = {new MyInteger(0),
                new MyInteger(5),
                new MyInteger(3),
                new MyInteger(4),
                new MyInteger(7),
                new MyInteger(2),
                new MyInteger(6)};
        MyInteger x = new MyInteger(20);

        for (int i = 0; i <= a.length; i++) {// search for x
            int j = SequentialSearch1.sequentialSearch(a, x);
            if (j < 0)
                System.out.println(x + " is not in the array");
            else
                System.out.println("a[" + j + "] = " + x);
            // look for next array object
            if (i < a.length) x = a[i];
        }
    }

}