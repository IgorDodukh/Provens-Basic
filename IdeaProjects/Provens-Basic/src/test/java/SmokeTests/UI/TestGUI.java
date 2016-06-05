package SmokeTests.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by igor on 05.06.16.
 */
public class TestGUI extends JFrame{
    private JComboBox browsersComboBox;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton startTestButton;

    private String[] browsers = {"Google Chrome", "Firefox", "Internet Explorer", "Safari"};
    private String[] entityTypes = {"Configure Merchant", "Add Customer", "Add Product", "Add Warehouse and Bin"};


    TestGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < browsers.length; i++) {
            browsersComboBox.addItem(browsers[i]);
        }

        for (int i = 0; i < entityTypes.length; i++) {
            comboBox1.addItem(entityTypes[i]);
        }
    }

    public static void main(String[] args) {
        TestGUI app = new TestGUI();
        app.setVisible(true);
    }
}
