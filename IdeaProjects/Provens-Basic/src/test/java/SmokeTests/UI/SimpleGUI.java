package SmokeTests.UI;

/**
 * Created by igor on 05.06.16.
 */

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.Tests.Jira3006_MerchantWarehouseAndBinCreation;
import SmokeTests.Tests.Jira3015_CreateProductAndBin;
import SmokeTests.Tests.Jira3675_AddNewCustomerWithCreditCard;
import SmokeTests.Tests.SetUpNewMerchant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static javax.swing.BorderFactory.createLineBorder;

public class SimpleGUI extends JFrame {
    public WebDriver driver;
    private BrowserSettings browserSettings = new BrowserSettings();

    SetUpNewMerchant setUpNewMerchant = new SetUpNewMerchant();
    Jira3675_AddNewCustomerWithCreditCard jira3675_AddNewCustomerWithCreditCard = new Jira3675_AddNewCustomerWithCreditCard();
    Jira3015_CreateProductAndBin jira3015_CreateProductAndBin = new Jira3015_CreateProductAndBin();
    Jira3006_MerchantWarehouseAndBinCreation jira3006_merchantWarehouseAndBinCreation = new Jira3006_MerchantWarehouseAndBinCreation();

    private JButton startButton = new JButton("Start Test");
    private JLabel browserLabel = new JLabel("Select Browser");
    private JLabel entityTypeLabel = new JLabel("Select Type");
    private JLabel environmentLabel = new JLabel("Select Environment");
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JLabel iconLabel = new JLabel("Build version: 0.8");
    private JLabel topSpaceLabel = new JLabel(" ");
    private JLabel middleSpaceLabel = new JLabel(" ");


    private JTextField loginField = new JTextField("", 15);
    private JPasswordField passwordField = new JPasswordField("", 15);

    Dimension d = new Dimension(200,30);

    private JComboBox<String> browsersComboBox = new JComboBox<String>();
    private JComboBox<String> entityTypeComboBox = new JComboBox<String>();
    private JComboBox<String> environmentsComboBox = new JComboBox<String>();

    private String[] browsers = {" Mozilla Firefox", " Google Chrome", " Internet Explorer", " Opera"};
    private String[] entityTypes = {" Configure Merchant", " Add Customer", " Add Product", " Add Warehouse & Bin"};
    private String[] environments = {" QA01", " QA03", " QA05", " Production"};

    SimpleGUI() throws IOException {
        super("Secret app for our team :)");

        this.setBounds(800,400,500,448);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        for (int i = 0; i < browsers.length; i++) {
            browsersComboBox.addItem(browsers[i]);
        }
        for (int i = 0; i < entityTypes.length; i++) {
            entityTypeComboBox.addItem(entityTypes[i]);
        }
        for (int i = 0; i < environments.length; i++) {
            environmentsComboBox.addItem(environments[i]);
        }

        BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Ihor\\IdeaProjects\\Provens-Basic\\IdeaProjects\\Provens-Basic\\src\\test\\java\\SmokeTests\\UI\\background.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        Color redColor = new Color(73, 134, 161);

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
        gbc.fill = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(7, 20, 2, 20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(topSpaceLabel, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        browserLabel.setForeground(new Color(95, 131, 156));
        browserLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        container.add(browserLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        browsersComboBox.setPreferredSize(d);
        browsersComboBox.setForeground(new Color(95, 131, 156));
        browsersComboBox.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        browsersComboBox.setBackground(Color.WHITE);
        container.add(browsersComboBox,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        entityTypeLabel.setForeground(new Color(95, 131, 156));
        entityTypeLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        container.add(entityTypeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        entityTypeComboBox.setPreferredSize(d);
        entityTypeComboBox.setForeground(new Color(95, 131, 156));
        entityTypeComboBox.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        entityTypeComboBox.setBackground(Color.WHITE);
        container.add(entityTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        environmentLabel.setForeground(new Color(95, 131, 156));
        environmentLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        container.add(environmentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        environmentsComboBox.setPreferredSize(d);
        environmentsComboBox.setForeground(new Color(95, 131, 156));
        environmentsComboBox.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        environmentsComboBox.setBackground(Color.WHITE);
        container.add(environmentsComboBox, gbc);

        gbc.insets = new Insets(14, 20, 2, 20);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        container.add(middleSpaceLabel, gbc);


        gbc.insets = new Insets(4, 20, 4, 20);

        gbc.gridx = 1;
        gbc.gridy = 5;
        loginLabel.setForeground(new Color(95, 131, 156));
        loginLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        container.add(loginLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
//        gbc.weighty = 0;
        passwordLabel.setForeground(new Color(95, 131, 156));
        passwordLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        container.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        loginField.setPreferredSize(d);
        //loginField.setForeground(new Color(95, 131, 156));
        loginField.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
        container.add(loginField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        passwordField.setPreferredSize(d);
        //passwordField.setForeground(new Color(95, 131, 156));
        passwordField.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
        container.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        startButton.setPreferredSize(d);
        startButton.setBackground(new Color(74, 126, 145));
        startButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));

        startButton.setForeground(Color.WHITE);

        Border line = new LineBorder(null);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        startButton.setBorder(compound);
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startButton.addActionListener(new ButtonEventListener());
        container.add(startButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        iconLabel.setForeground(Color.GRAY);
        iconLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
        container.add(iconLabel, gbc);


        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 12;
        gbc.gridwidth= 2;
        picLabel.setBounds(0,0,0,0);
        picLabel.setVisible(true);
        container.add(picLabel, gbc);

    }



    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int browserComboBoxIndex = browsersComboBox.getSelectedIndex();
            int environmentComboBoxIndex = environmentsComboBox.getSelectedIndex();
            int entityTypeComboBoxIndex = entityTypeComboBox.getSelectedIndex();

            String loginValue = loginField.getText();
            String password = String.valueOf(passwordField.getPassword());

            boolean loginFilled = false;
            boolean passFilled = false;
            if (Objects.equals(loginValue, "")){
                loginField.setBorder(createLineBorder(Color.RED));
                loginLabel.setForeground(Color.RED);
                loginFilled = false;
            } else if (!Objects.equals(loginValue, "")) {
                loginField.setBorder(createLineBorder(Color.decode("#5f839c")));
                loginLabel.setForeground(Color.decode("#5f839c"));
                loginFilled = true;
            }
            if (Objects.equals(password, "")) {
                passwordField.setBorder(createLineBorder(Color.RED));
                passwordLabel.setForeground(Color.RED);
                passFilled = false;
            } else if (!Objects.equals(password, "")) {
                passwordField.setBorder(createLineBorder(Color.decode("#5f839c")));
                passwordLabel.setForeground(Color.decode("#5f839c"));
                passFilled = true;
            }
            if (loginFilled && passFilled) {
                String infoMessage = "";
                infoMessage += "Test will be started now\n\n";
                infoMessage += "Selected Browser: " + browsersComboBox.getSelectedItem() + "\n\n";
                infoMessage += "Selected Test: " + entityTypeComboBox.getSelectedItem() + "\n\n";
                infoMessage += "Selected Environment: " + environmentsComboBox.getSelectedItem() + "\n\n";
                infoMessage += "Performing the test will take some time. Please wait! \nMake a cup of tea or hug your cat :)\n\n";

                JOptionPane.showMessageDialog(null,
                        infoMessage,
                        "Confirmation",
                        JOptionPane.INFORMATION_MESSAGE);

                if (browserComboBoxIndex == 0) {
                    driver = new FirefoxDriver();
                } else if (browserComboBoxIndex == 1) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                    driver = new ChromeDriver();
                } else if (browserComboBoxIndex == 2) {
                    System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
                    driver = new InternetExplorerDriver();
                } else if (browserComboBoxIndex == 3) {
                    System.setProperty("webdriver.opera.driver", "C:\\Program Files (x86)\\Opera\\launcher.exe");
                    driver = new OperaDriver();
                }

                browserSettings.setUp(environmentComboBoxIndex, browserComboBoxIndex, driver);

                try {
                    if (entityTypeComboBoxIndex == 0) {
                        setUpNewMerchant.setupNewMerchant(loginValue, password, driver);
                    } else if (entityTypeComboBoxIndex == 1) {
                        jira3675_AddNewCustomerWithCreditCard.jira3675(loginValue, password, driver);
                    } else if (entityTypeComboBoxIndex == 2) {
                        jira3015_CreateProductAndBin.jira3015(loginValue, password, driver);
                    } else if (entityTypeComboBoxIndex == 3) {
                        jira3006_merchantWarehouseAndBinCreation.jira3006(loginValue, password, driver);
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                String resultMessage = "";
                resultMessage += "Test has been finished\n";
                JOptionPane.showMessageDialog(null,
                        resultMessage,
                        "Process",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}
