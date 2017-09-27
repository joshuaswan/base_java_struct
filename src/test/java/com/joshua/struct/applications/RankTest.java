package com.joshua.struct.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/9/27.
 */
public class RankTest {
    @Test
    public void rank() throws Exception {
        Integer[] a = {new Integer(2),
                new Integer(6),
                new Integer(4),
                new Integer(3),
                new Integer(1),
                new Integer(5)};
        int[] r = new int[10];

        // output elements to be ranked
        System.out.println("The elements are");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        // rank the elements
        Rank.rank(a, r);

        // output the ranks
        System.out.println("The ranks are");
        for (int i = 0; i < a.length; i++)
            System.out.print(r[i] + " ");
        System.out.println();
    }

}