package net.ikorni.testprojects.javaimages;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Tina on 02.10.2016.
 */
public class ImageService {

    public static BufferedImage uploadPicture(String path) throws IOException{
        return ImageIO.read(new File(path));
    }

    public static void savePicture(BufferedImage image, String path, String format) throws IOException {
        File outputfile = new File(path + "." + format);
        ImageIO.write(image, format, outputfile);
    }

    public static BufferedImage scaleImage(BufferedImage image, int width, int height, int method) {
        Image tmp = image.getScaledInstance(width, height, method);
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return result;
    }

    public static BufferedImage drawImage(int width, int height, Color color){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        return image;
    }

}
