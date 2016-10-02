package net.ikorni.testprojects.javaimages;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Tina on 02.10.2016.
 */
public class ImageTest {

    @BeforeClass
    public static void deleteImages() {
        try {
            Files.deleteIfExists(Paths.get("out/test/Java Images/blackPicture.jpg"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureAreaAveraging.gif"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureAreaAveraging.jpeg"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureAreaAveraging.jpg"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureAreaAveraging.png"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureFast.gif"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureFast.jpg"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureFast.png"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureReplicate.gif"));
            Files.deleteIfExists(Paths.get("rout/test/Java Images/resizedPictureReplicate.jpg"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureReplicate.png"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureSmooth.gif"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureSmooth.jpg"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/resizedPictureSmooth.png"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/savedPicture.gif"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/savedPicture.jpg"));
            Files.deleteIfExists(Paths.get("out/test/Java Images/savedPicture.png"));
        } catch (IOException ioException) {
            System.out.println("Not all images were deleted before the test-run!");
        }
    }

    @Test
    public void testUpload() {
        try {
            ImageService.uploadPicture("out/test/Java Images/testPicture.jpg");
        } catch (IOException ioException) {
            Assert.fail("The image could not be uploaded");
        }
    }

    @Test
    public void testAttributes() {
        BufferedImage image = null;
        try {
            image = ImageService.uploadPicture("out/test/Java Images/testPicture.jpg");
        } catch (IOException ioException) {
            Assert.fail("The image could not be uploaded");
        }

        System.out.println("The image's height is: " + image.getHeight());
        System.out.println("The image's width is: " + image.getWidth());
        System.out.println("The image's min X is: " + image.getMinX());
        System.out.println("The image's min y is: " + image.getMinY());
        System.out.println("The image's min TileX is: " + image.getMinTileX());
        System.out.println("The image's min TileY is: " + image.getMinTileY());
        System.out.println("The image's data is: " + image.getData());

    }

    @Test
    public void testSave() {
        BufferedImage image = null;

        try {
            image = ImageService.uploadPicture("out/test/Java Images/testPicture.jpg");
        } catch (IOException e) {
            Assert.fail("The image could not be uploaded");
        }

        try {
            ImageService.savePicture(image, "out/test/Java Images/savedPicture", "png");
            ImageService.savePicture(image, "out/test/Java Images/savedPicture", "jpg");
            ImageService.savePicture(image, "out/test/Java Images/savedPicture", "gif");
        } catch (IOException ioException) {
            Assert.fail("The image could not be saved");
        }

    }

    @Test
    public void testScaling() {
        BufferedImage image = null;
        BufferedImage result;
        try {
            image = ImageService.uploadPicture("out/test/Java Images/testPicture.jpg");
        } catch (IOException ioException) {
            Assert.fail("The image could not be uploaded");
        }

        result = ImageService.scaleImage(image, 200, 200, Image.SCALE_SMOOTH);
        try {
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureSmooth", "png");
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureSmooth", "jpg");
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureSmooth", "gif");
        } catch (IOException ioException) {
            Assert.fail("The image could not be saved");
        }

        result = ImageService.scaleImage(image, 200, 200, Image.SCALE_SMOOTH);
        try {
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureFast", "png");
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureFast", "jpg");
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureFast", "gif");
        } catch (IOException ioException) {
            Assert.fail("The image could not be saved");
        }

        result = ImageService.scaleImage(image, 200, 200, Image.SCALE_SMOOTH);
        try {
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureReplicate", "png");
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureReplicate", "jpg");
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureReplicate", "gif");
        } catch (IOException ioException) {
            Assert.fail("The image could not be saved");
        }

        result = ImageService.scaleImage(image, 200, 200, Image.SCALE_SMOOTH);
        try {
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureAreaAveraging", "png");
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureAreaAveraging", "jpg");
            ImageService.savePicture(result, "out/test/Java Images/resizedPictureAreaAveraging", "gif");
        } catch (IOException ioException) {
            Assert.fail("The image could not be saved");
        }
    }

    @Test
    public void testCreateImage() {
        BufferedImage image = ImageService.drawImage(250, 250, Color.white);

        try {
            ImageService.savePicture(image, "out/test/Java Images/blackPicture", "jpg");
        } catch (IOException ioException) {
            Assert.fail("The image could not be saved");
        }
    }
}