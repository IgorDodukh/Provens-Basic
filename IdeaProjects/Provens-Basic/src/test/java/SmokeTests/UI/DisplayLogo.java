package SmokeTests.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by igor on 10.06.16.
 */
public class DisplayLogo extends Component {
    private BufferedImage img;

    public DisplayLogo() {
        try {
            img = ImageIO.read(new File("fs.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public static void main(String[] args) {
    }
}
