package com.joshua.struct.applications;

import com.joshua.struct.wrappers.MyInteger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/9/12.
 */
public class EvaluatePolynomialTest {
    @Test
    public void valueOf() throws Exception {
        MyInteger[] coeff = {new MyInteger(1),
                new MyInteger(2),
                new MyInteger(3),
                new MyInteger(4),
                new MyInteger(5),
                new MyInteger(6)};
        MyInteger x = new MyInteger(2);
        EvaluatePolynomial.valueOf(coeff,x);
    }

}