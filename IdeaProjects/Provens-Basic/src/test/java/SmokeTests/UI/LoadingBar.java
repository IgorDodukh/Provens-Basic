package SmokeTests.UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Ihor on 6/22/2016.
 */
public class LoadingBar {
    public static void main(String args[]) {
        JFrame f = new JFrame("JProgressBar Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = f.getContentPane();
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(25);
        progressBar.setStringPainted(true);
        Border border = BorderFactory.createTitledBorder("Reading...");
        progressBar.setBorder(border);
        content.add(progressBar, BorderLayout.NORTH);
        f.setSize(300, 100);
        f.setVisible(true);
    }
}

