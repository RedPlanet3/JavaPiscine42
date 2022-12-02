package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.io.IOException;

public class Program {

    public static void checkArg(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Wrong arg number!");
            System.exit(-1);
        }

        if ((args[1].length() > 1) || (args[0].length() > 1))
        {
            System.out.println("Wrong arg dots!");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {

        checkArg(args);
        try {
            Logic.readBMP(args[1].charAt(0), args[0].charAt(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
