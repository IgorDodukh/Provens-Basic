package SmokeTests.UI;

/**
 * Created by igor on 05.06.16.
 */
import SmokeTests.Pages.LoginPage;
import SmokeTests.Settings.BrowserSettings;
import SmokeTests.Tests.SetUpNewMerchant;
import javafx.scene.layout.BorderPane;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;

import static java.awt.PageAttributes.ColorType.COLOR;

public class SimpleGUI extends JFrame {

    BrowserSettings browserSettings = new BrowserSettings();
//    LoginPage loginPage = new LoginPage();

    SetUpNewMerchant setUpNewMerchant = new SetUpNewMerchant();

    private JButton startButton = new JButton("Start Test");
    private JLabel browserLabel = new JLabel("Select Browser");
    private JLabel entityTypeLabel = new JLabel("Select Type");
    private JLabel environmentLabel = new JLabel("Select Environment");
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField loginField = new JTextField("", 15);
    private JPasswordField passwordField = new JPasswordField("", 15);

    Dimension d = new Dimension(40,30);

    private JComboBox<String> browsersComboBox = new JComboBox<String>();
    private JComboBox<String> entityTypeComboBox = new JComboBox<String>();
    private JComboBox<String> environmentsComboBox = new JComboBox<String>();

    private String[] browsers = {" Mozilla Firefox", " Google Chrome", " Internet Explorer", " Safari"};
    private String[] entityTypes = {" Configure Merchant", " Add Customer", " Add Product", " Add Warehouse and Bin"};
    private String[] environments = {" QA01", " QA03", " QA05", " Production"};

    SimpleGUI() {
        super("Secret app for our team :)");

        this.setBounds(800,400,450,300);
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

        Color redColor = new Color(175, 226, 255);

        Object child = environmentsComboBox.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup)child;
        JList list = popup.getList();
        list.setSelectionBackground(redColor);

        Object child2 = browsersComboBox.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup2 = (BasicComboPopup)child2;
        JList list2 = popup2.getList();
        list2.setSelectionBackground(redColor);

        Object child3 = entityTypeComboBox.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup3 = (BasicComboPopup)child3;
        JList list3 = popup3.getList();
        list3.setSelectionBackground(redColor);



        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());

        container.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 8, 8, 8);

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(browserLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        browsersComboBox.setPreferredSize(d);
        browsersComboBox.setBackground(Color.WHITE);
        container.add(browsersComboBox,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(entityTypeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        entityTypeComboBox.setPreferredSize(d);
        entityTypeComboBox.setBackground(Color.WHITE);
        container.add(entityTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(environmentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        environmentsComboBox.setPreferredSize(d);
        environmentsComboBox.setBackground(Color.WHITE);
        container.add(environmentsComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        container.add(loginLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        container.add(passwordLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        loginField.setPreferredSize(d);
        loginField.setFont(new java.awt.Font("Tahoma", 3, 12));
        container.add(loginField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        passwordField.setPreferredSize(d);
        passwordField.setFont(new java.awt.Font("Tahoma", 3, 12));
        container.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        startButton.setPreferredSize(d);
        startButton.addActionListener(new ButtonEventListener());
        container.add(startButton, gbc);
    }

    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int environmentsComboBoxSelectedIndex = environmentsComboBox.getSelectedIndex();

            String loginValue = loginField.getText();
            char[] passwordValue = passwordField.getPassword();

            String password = passwordValue.toString();

            String infoMessage = "";
            infoMessage += "Test will be started now\n\n";
            infoMessage += "Selected Browser: " + browsersComboBox.getSelectedItem() + "\n\n";
            infoMessage += "Selected Test: " + entityTypeComboBox.getSelectedItem() + "\n\n";
            infoMessage += "Selected Environment: " + environmentsComboBox.getSelectedItem() + "\n\n";
            infoMessage += "Performing the test will take some time. Please wait! \nMake a cup of tea for you and your friend :)\n\n";

            JOptionPane.showMessageDialog(null,
                    infoMessage,
                    "Confirmation",
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
