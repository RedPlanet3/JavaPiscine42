package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logic {

    public static void readBMP(char black, char white) throws IOException {

        BufferedImage img  = ImageIO.read(Logic.class.getResource("/resources/it.bmp"));

            for (int i = 0; i < img.getHeight(); i++) {
                for (int j = 0; j < img.getWidth(); j++) {
                    int pixel = img.getRGB(j, i);
                    if ((pixel & 0x00FFFFFF) == 0)	{
                        System.out.print(black);
                    } else {
                        System.out.print(white);
                    }
                }
                System.out.println();
            }
    }
}
