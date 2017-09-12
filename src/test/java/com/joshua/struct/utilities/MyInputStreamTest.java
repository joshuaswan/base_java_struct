package com.joshua.struct.utilities;

import com.joshua.struct.exceptions.MyInputException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshua on 2017/9/6.
 */
public class MyInputStreamTest {
//    @Test
    public void test(){
        boolean b;
        int i, j, k;
        double d;
        byte c;
        short f;
        String g;

        // define a MyInputStream object to input
        // from System.in and another to input from
        // the file utilities\MyInputStream.file
        MyInputStream keyboard = new MyInputStream(),
                file = new MyInputStream
                        ("utilities/MyInputStream.file");

        System.out.println("Enter a boolean, an integer " +
                "a double, a byte, a short, " +
                " and a string");
        System.out.flush();  // force output of last line

        b = keyboard.readBoolean();
        i = keyboard.readInteger();
        d = keyboard.readDouble();
        c = keyboard.readByte();
        f = keyboard.readShort();
        g = keyboard.readString();
        keyboard.flushCurrentLine();

        System.out.println("The input is " + b +
                " " + i + " " + d + " " +
                c + " " + f + " " + g);

        // now read from the file and output
        b = file.readBoolean();
        i = file.readInteger();
        d = file.readDouble();
        keyboard.flushCurrentLine();

        System.out.println("The file input is " + b +
                " " + i + " " + d);

        System.out.println("Enter three integers, " +
                "one to a line");
        System.out.flush();  // force output of last line
        i = keyboard.readInteger();
        keyboard.flushCurrentLine();
        j = keyboard.readInteger();
        keyboard.flushCurrentLine();
        k = keyboard.readInteger();
        keyboard.flushCurrentLine();

        System.out.println("The input is " + i +
                " " + j + " " + k);

        // try another read from the file
        // should throw end of file exception
        file.flushCurrentLine();
        try {
            b = file.readBoolean();
        }
        catch (MyInputException e)
        {System.out.println
                ("MyInputException: " + e.getMessage());
        }
    }

}