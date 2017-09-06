package com.joshua.struct.utilities;

import java.io.*;
import java.util.*;

import com.joshua.struct.exceptions.*;

/**
 * Created by joshua on 2017/9/6.
 */
public class MyInputStream {
    // data members
    private BufferedReader in;
    private StringTokenizer line;

    /** Constructor to set up BufferedReader
     * for standard input stream System.in.
     * Typically, this is the keyboard. */

    public MyInputStream()
    {
        in = new BufferedReader
                (new InputStreamReader(System.in));
    }

    /** Constructor to set up BufferedReader
     * for input from a file. */

    public MyInputStream(String fileName)
    {
        try
        {
            in = new BufferedReader
                    (new FileReader(fileName));
        }
        catch (FileNotFoundException e)
        {throw new MyInputException(e.getMessage());}
    }

    /** Discard remainder of current line. */
    public void flushCurrentLine()
    {
        line = null;
    }

    /** Extract next token from input stream.
     * @return next token in input stream
     * @exception MyInputException thrown if
     * some error occurs while inputting a new
     * line or if the end of file is reached */

    private String nextToken()
    {
        // ensure that the current line has a token
        while (line == null || !line.hasMoreTokens())
        {
            try
            {
                // attempt to input another line
                String newLine = in.readLine();
                if (newLine == null)  // end of file encountered
                    throw new MyInputException("End of file");

                // convert newLine to tokens
                line = new StringTokenizer(newLine);
            }
            catch (IOException e)
            {throw new MyInputException(e.getMessage());}

        }

        // extract and return the next token
        return line.nextToken();
    }

    /** Input an integer.
     * @exception MyInputException
     * @exception NumberFormatException
     * @return next token as an integer number */

    public int readInteger()
    {
        return Integer.parseInt(nextToken());
    }

    /** Input a long. */
    public long readLong()
    {
        return Long.parseLong(nextToken());
    }

    /** Input a short. */
    public short readShort()
    {
        return Short.parseShort(nextToken());
    }

    /** Input a byte. */
    public byte readByte()
    {
        return Byte.parseByte(nextToken());
    }

    /** Input a float. */
    public float readFloat()
    {
        return new Float(nextToken()).floatValue();
    }

    /** Input a double. */
    public double readDouble()
    {
        return new Double(nextToken()).doubleValue();
    }

    /** Input a string. */
    public String readString()
    {
        return nextToken();
    }

    /** Input a boolean. */
    public boolean readBoolean()
    {
        String b = nextToken();
        if (b.equals("true")) return true;
        if (b.equals("false")) return false;
        throw new MyInputException
                ("Input is not a boolean");
    }
}
