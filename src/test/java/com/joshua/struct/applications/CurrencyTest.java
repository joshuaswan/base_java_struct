package com.joshua.struct.applications;

import org.junit.Test;

/**
 * Created by joshua on 2016/12/5.
 */
public class CurrencyTest {

    @Test
    public void currencyTest(){
        //test constructors
        Currency g = new Currency(),
                 h = new Currency(Currency.PLUS, 3L ,(byte) 50),
                 i = new Currency(-2.50),
                 j = new Currency();

        //test toString
        System.out.println("The initial values are " + g + " " + h + " " + i + " " + j);

        System.out.println();

        //test mutators
        //first make g nonzero
        g.setDollars(2);
        g.setSign(Currency.MINUS);
        g.setCents((byte) 25);
        i.setValue(-6.45);
        System.out.println("New values are " + g + " " + i);
        System.out.println();

        //do some arithmetic
        j = h.add(g);
        System.out.println(h + " + " + g + " = " + j);
        System.out.print(i + " incremented by " + h + " is ");
        i.increment(h);
        System.out.println(i);

        j = i.add(g).add(h);
        System.out.println( i + " + " + g + " + " + h + " = " + j);

        j = i.increment(g).add(h);
        System.out.println(j);
        System.out.println(i);
    }
}