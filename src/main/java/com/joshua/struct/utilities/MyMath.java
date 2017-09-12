package com.joshua.struct.utilities;

/**
 * Created by joshua on 2017/9/12.
 */
public class MyMath {
    /** @return sum of the integers a[0:n-1] */
    public static int sum(int [] a, int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];
        return sum;
    }

    /** Generic sum method.
     * @return null if array has no objects and
     * sum of the objects a[0:n-1] otherwise */
    public static Computable sum(Computable [] a, int n)
    {
        if (a.length == 0) return null;
        Computable sum = (Computable) a[0].zero();
        for (int i = 0; i < n; i++)
            sum.increment(a[i]);
        return sum;
    }

    /** Swap the integers a[i] and a[j]. */
    public static void swap(int [] a, int i, int j)
    {
        // Don't bother to check that indexes i and j
        // are in bounds. Java will do this and throw
        // an ArrayIndexOutOfBoundsException if i or
        // j is out of bounds.
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /** Generic method to swap the object
     * references a[i] and a[j]. */
    public static void swap(Object [] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /** @return n! */
    public static int factorial(int n)
    {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    /** generic method to find maximum object in a[0:n]
     * @throws IllegalArgumentException when n < 0
     * @return position of max element in a[0:n] */
    public static int max(Comparable [] a, int n)
    {
        if (n < 0)
            throw new IllegalArgumentException
                    ("MyMath.max: Cannot find max of zero elements ");

        int positionOfCurrentMax = 0;
        for (int i = 1; i <= n; i++)
            if (a[positionOfCurrentMax].compareTo(a[i]) < 0)
                positionOfCurrentMax = i;
        return positionOfCurrentMax;
    }
}
