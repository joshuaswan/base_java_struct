package com.joshua.struct.misc;

import com.joshua.struct.utilities.MyInputStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by joshua on 2017/9/6.
 */
public class Array1D {
    // instance data member
    Object[] a ;

    // method of Array1D
    public void inputArray(Class theClass, MyInputStream stream){
        try {
            //get the proper  method to be used to read in the values
            Class[] parameterTypes = {MyInputStream.class};
            Method inputMethod = theClass.getMethod("input",parameterTypes);

            //input number of elements and create an array of that size
            System.out.println("Enter number of elements");
            int n = stream.readInteger();
            a = new Object[n];

            //input the elements
            Object[] inputMethodArgs = {stream};
            for (int i=0 ;i<n;i++){
                System.out.println("Enter element " + (i+1));
                a[i] = inputMethod.invoke(null,inputMethodArgs);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
