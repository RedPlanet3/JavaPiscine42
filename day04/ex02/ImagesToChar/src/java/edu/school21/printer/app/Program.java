package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import edu.school21.printer.logic.Args;
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
    }

    public static void main(String[] args) {
        Args jcArgs = new Args();
        JCommander.newBuilder()
                .addObject(jcArgs)
                .build()
                .parse(args);
//        System.out.println(jcArgs.getFirst());
//        System.out.println(jcArgs.getSecond());
        checkArg(args);
        try {
            Logic.readBMP(jcArgs.getFirst(), jcArgs.getSecond());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
