package com.joshua.struct.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2016/12/5.
 */
public class LengthTest {

    @Test
    public void lengthTest(){
        Length length = new Length(10.2983);
        System.out.println(length.toString());

        Length length1 = new Length(true,12,(byte)87,(byte) 99);

        System.out.println(length.add(length1));
    }
}