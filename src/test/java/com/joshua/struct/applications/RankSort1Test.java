package com.joshua.struct.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/9/27.
 */
public class RankSort1Test {
    @Test
    public void rankSort() throws Exception {
        Integer [] a = {new Integer(3),
                new Integer(2),
                new Integer(4),
                new Integer(1),
                new Integer(6),
                new Integer(9),
                new Integer(8),
                new Integer(7),
                new Integer(5),
                new Integer(0)};

        // output elements to be sorted
        System.out.println("The elements are");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        // sort the elements
        RankSort1.rankSort(a);

        // output in sorted order
        System.out.println("The sorted order is");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}