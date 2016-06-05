package SmokeTests.UI;

/**
 * Created by igor on 05.06.16.
 */
import SmokeTests.Settings.BrowserSettings;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {

    BrowserSettings browserSettings = new BrowserSettings();


    private JButton StartButton = new JButton("  Start Test");
    private JTextField input = new JTextField("", 5);
    private JLabel browserLabel = new JLabel("  Select Browser ");
    private JLabel entityTypeLabel = new JLabel("  Select Type ");
    private JLabel environmentLabel = new JLabel("  Select Environment ");
    private JRadioButton radio1 = new JRadioButton("  Select this");
    private JRadioButton radio2 = new JRadioButton("  Select that");
    private JCheckBox check = new JCheckBox("  Check", false);
    private JLabel loginLabel = new JLabel("  Login: ");
    private JLabel passwordLabel = new JLabel("  Password: ");
    private JTextField login = new JTextField("", 5);
    private JPasswordField password = new JPasswordField("", 5);


    private JComboBox<String> browsersComboBox = new JComboBox<String>();
    private JComboBox<String> entityTypeComboBox = new JComboBox<String>();
    private JComboBox<String> environmentsComboBox = new JComboBox<String>();

    private String[] browsers = {" Firefox", " Google Chrome", " Internet Explorer", " Safari"};
    private String[] entityTypes = {" Configure Merchant", " Add Customer", " Add Product", " Add Warehouse and Bin"};
    private String[] environments = {" QA01", " QA03", " QA05", " Production"};


    SimpleGUI() {
        super("Secret app for team :) ");

        this.setBounds(800,400,350,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < browsers.length; i++) {
            browsersComboBox.addItem(browsers[i]);
        }

        for (int i = 0; i < entityTypes.length; i++) {
            entityTypeComboBox.addItem(entityTypes[i]);
        }

        for (int i = 0; i < environments.length; i++) {
            environmentsComboBox.addItem(environments[i]);
        }



        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6,0,10,10));
        container.add(browserLabel);
        container.add(browsersComboBox);
        container.add(entityTypeLabel);
        container.add(entityTypeComboBox);
        container.add(environmentLabel);
        container.add(environmentsComboBox);
        container.add(loginLabel);

        container.add(passwordLabel);
        container.add(login);
        container.add(password);


        StartButton.addActionListener(new ButtonEventListener());
        container.add(StartButton);
    }

    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int environmentsComboBoxSelectedIndex = environmentsComboBox.getSelectedIndex();

            String infoMessage = "";
            infoMessage += "Test has been started\n\n";
            infoMessage += "Selected Browser: " + browsersComboBox.getSelectedItem() + "\n\n";
            infoMessage += "Selected Environment: " + environmentsComboBox.getSelectedItem() + "\n\n";
            infoMessage += "Selected Test: " + entityTypeComboBox.getSelectedItem() + "\n\n";

            JOptionPane.showMessageDialog(null,
                    infoMessage,
                    "Process",
                    JOptionPane.INFORMATION_MESSAGE);

            browserSettings.setUp(environmentsComboBoxSelectedIndex);

            String resultMessage = "";
            resultMessage += "Test has been finished\n";
            JOptionPane.showMessageDialog(null,
                    resultMessage,
                    "Process",
                    JOptionPane.PLAIN_MESSAGE);


        }
    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}
