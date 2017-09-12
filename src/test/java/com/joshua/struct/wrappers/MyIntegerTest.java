package com.joshua.struct.wrappers;

import com.joshua.struct.utilities.MyMath;
import com.joshua.struct.utilities.Operable;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/9/12.
 */
public class MyIntegerTest {
    @Test
    public void test(){
        Operable[] z = new Operable[5];
        for (int i = 0; i < z.length; i++)
            z[i] = new MyInteger(i * i + 1);

        System.out.println("Testing the MyInteger wrapper class");
        // output the array
        System.out.print("The test array is ");
        for (int i = 0; i < z.length; i++)
            System.out.print(z[i] + " ");
        System.out.println();

        // test Computable interface operations
        System.out.println(z[1] + " + " + z[2] + " = " + z[1].add(z[2]));
        System.out.println(z[2] + " - " + z[1] + " = " + z[2].subtract(z[1]));
        System.out.println(z[1] + " * " + z[2] + " = " + z[1].multiply(z[2]));
        System.out.println(z[2] + " / " + z[0] + " = " + z[2].divide(z[0]));
        System.out.println("The zero element is " + z[2].zero());
        System.out.println("The identity element is " + z[2].identity());
        System.out.println();

        // test Comparable interface operation
        System.out.println(z[1] + " compareTo(" + z[2] + ") = " +
                z[1].compareTo(z[2]));
        System.out.println(z[2] + " compareTo(" + z[1] + ") = " +
                z[2].compareTo(z[1]));
        System.out.println(z[2] + " compareTo(" + z[2] + ") = " +
                z[2].compareTo(z[2]));
        System.out.println();

        // test equals
        System.out.println(z[1] + " == " + z[2] + " = " + z[1].equals(z[2]));
        System.out.println(z[1] + " == " + z[1] + " = " + z[1].equals(z[1]));
        System.out.println();

        // test generic sum method
        System.out.println("The sum of the integers is " +
                MyMath.sum(z, z.length));
        System.out.println();

        // test generic swap method
        MyMath.swap(z, 0, z.length - 1);
        // output the array
        System.out.print("After swapping the first and last "
                + "elements, the test array is ");
        for (int i = 0; i < z.length; i++)
            System.out.print(z[i] + " ");
        System.out.println();
        System.out.println();

        // test generic max function
        try {
            System.out.println("The maximum element is " +
                    z[MyMath.max(z, z.length - 1)]);
        }
        catch (IllegalArgumentException e)
        {System.out.println(e.getMessage());}
    }
}