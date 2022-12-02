package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Logic {

    public static void readBMP(String black, String white) throws IOException {
        ColoredPrinter printer = new ColoredPrinter();
        int pixel;
        BufferedImage img  = ImageIO.read(Logic.class.getResource("/resources/it.bmp"));

            for (int i = 0; i < img.getHeight(); i++) {
                for (int j = 0; j < img.getWidth(); j++) {
                    pixel = img.getRGB(j, i);
                    if ((pixel & 0x00FFFFFF) == 0)	{
                        printer.print(" ", Ansi.Attribute.NONE,
                                Ansi.FColor.NONE, Ansi.BColor.valueOf(black));
                    } else {
                        printer.print(" ", Ansi.Attribute.NONE,
                                Ansi.FColor.NONE, Ansi.BColor.valueOf(white));
                    }
                }
                System.out.println();
            }
    }
}
