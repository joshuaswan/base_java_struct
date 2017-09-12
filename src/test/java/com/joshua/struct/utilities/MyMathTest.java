package com.joshua.struct.utilities;

import org.junit.Test;

import static com.joshua.struct.utilities.MyMath.*;

/**
 * Created by joshua on 2017/9/12.
 */
public class MyMathTest {


    /** Test integer MyMath methods.
     * The generic methods are tested by
     * MyInteger.main. */

    @Test
    public void test(){
        // create an integer array with 5 elements
        // you can change this to your own data
        int [] z = {2, 4, 5, 3, 1};

        // test integer sum
        // output the array
        System.out.print("The test array is ");
        for (int i = 0; i < z.length; i++)
            System.out.print(z[i] + " ");
        System.out.println();

        // output the sum
        System.out.println("The sum is " + sum(z, z.length));

        // test integer swap
        swap(z, 0, z.length - 1);
        // output the array
        System.out.print("After swapping the first and last "
                + "integers, the test array is ");
        for (int i = 0; i < z.length; i++)
            System.out.print(z[i] + " ");
        System.out.println();

        // test factorial
        System.out.println("(-3)! = " + factorial(-3));
        System.out.println("5! = " + factorial(5));
    }
}