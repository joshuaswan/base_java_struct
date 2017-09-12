package com.joshua.struct.applications;


import com.joshua.struct.utilities.Computable;

/**
 * Created by joshua on 2017/9/12.
 */
public class EvaluatePolynomial {

    public static Computable valueOf(Computable[] coeff, Computable x){
        if (coeff.length<1){
            throw new IllegalArgumentException("must have >= coefficient");
        }
        Computable y = (Computable) coeff[0].identity();
        Computable value = coeff[0];

        for (int i=1;i<coeff.length;i++){
            y = (Computable) y.multiply(x);

            value.increment(y.multiply(coeff[i]));
        }

        return value;
    }
}
