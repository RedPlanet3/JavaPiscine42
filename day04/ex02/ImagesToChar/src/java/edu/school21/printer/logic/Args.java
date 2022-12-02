package edu.school21.printer.logic;


import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Args {

    @Parameter(names = {"--white"})
    private String first;
    @Parameter(names = {"--black"})
    private String second;


    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}
