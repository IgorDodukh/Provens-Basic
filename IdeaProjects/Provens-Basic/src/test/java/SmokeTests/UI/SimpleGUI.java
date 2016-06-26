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

import javax.imageio.ImageIO;
import javax.swing.*;
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
//    LoginPage loginPage = new LoginPage(driver);

//  Main window elements
    private JButton startButton = new JButton("Start Test");
    private JLabel browserLabel = new JLabel("Select Browser");
    private JLabel entityTypeLabel = new JLabel("Select Test Type");
    private JLabel environmentLabel = new JLabel("Select Environment");
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JLabel buildVersionLabel = new JLabel("Build Version: 0.99");
    private JLabel topSpaceLabel = new JLabel(" ");
    private JLabel middleSpaceLabel = new JLabel(" ");
    private JLabel waitingLabel = new JLabel("Test is running...");

//  Graphical resources
    final ImageIcon animatedIcon = new ImageIcon("C:\\appFiles\\pic\\spinner.gif");
    final BufferedImage appIcon = ImageIO.read(new File("C:\\appFiles\\pic\\8-512.png"));
    final BufferedImage background = ImageIO.read(new File("C:\\appFiles\\pic\\background.png"));
    final ImageIcon icon = new ImageIcon("C:\\appFiles\\pic\\smile2.png");
    final ImageIcon success = new ImageIcon("C:\\appFiles\\pic\\success.png");
    final ImageIcon sad = new ImageIcon("C:\\appFiles\\pic\\sad.png");
    final ImageIcon hmm = new ImageIcon("C:\\appFiles\\pic\\hmm.png");
    final ImageIcon authorize = new ImageIcon("C:\\appFiles\\pic\\authorize-net.png");

    private JLabel waitingAnimation = new JLabel(new ImageIcon(String.valueOf(animatedIcon)));
    private JTextField loginField = new JTextField("newadmin@dydacomp.biz", 15);
    private JPasswordField passwordField = new JPasswordField("78qa22!#", 15);

    Dimension d = new Dimension(200,30);

    private JComboBox<String> browsersComboBox = new JComboBox<>();
    private JComboBox<String> entityTypeComboBox = new JComboBox<>();
    private JComboBox<String> environmentsComboBox = new JComboBox<>();

    private String[] browsers = {" Mozilla Firefox", " Google Chrome"};
    private String[] entityTypes = {" Configure Merchant", " Add Customer", " Add Product (not ready)", " Add Warehouse & Bin"};
    private String[] environments = {" QA01", " QA03", " QA05", " Production (for mad guys)"};

    boolean exceptionStatus = false;
//    boolean credentialsValid = false;


    public SimpleGUI() throws IOException {
        super("Secret app for our team :)");

//  Main app configs
        this.setBounds(800,400,500,448);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(appIcon);
        waitingAnimation.setVisible(false);
        waitingLabel.setVisible(false);

//  Add items to dropdown-lists
        for (String browser : browsers) {
            browsersComboBox.addItem(browser);
        }
        for (String entityType : entityTypes) {
            entityTypeComboBox.addItem(entityType);
        }
        for (String environment : environments) {
            environmentsComboBox.addItem(environment);
        }

        JLabel picLabel = new JLabel(new ImageIcon(background));

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

// Define container for all UI objects
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

//  Object type position
        gbc.gridx = 1;
        gbc.gridy = 2;
        entityTypeComboBox.setPreferredSize(d);
        entityTypeComboBox.setForeground(new Color(95, 131, 156));
        entityTypeComboBox.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        entityTypeComboBox.setBackground(Color.WHITE);
        container.add(entityTypeComboBox, gbc);

//  Environments label position
        gbc.gridx = 0;
        gbc.gridy = 3;
        environmentLabel.setForeground(new Color(95, 131, 156));
        environmentLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        container.add(environmentLabel, gbc);

//  Environments dropdown position
        gbc.gridx = 1;
        gbc.gridy = 3;
        environmentsComboBox.setPreferredSize(d);
        environmentsComboBox.setForeground(new Color(95, 131, 156));
        environmentsComboBox.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        environmentsComboBox.setBackground(Color.WHITE);
        container.add(environmentsComboBox, gbc);

//  Size parameters for the middle section
        gbc.insets = new Insets(14, 20, 2, 20);

//  Middle space position
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        container.add(middleSpaceLabel, gbc);

//  Size parameters for the bottom section
        gbc.insets = new Insets(4, 20, 4, 20);

//  "Login" field position
        gbc.gridx = 1;
        gbc.gridy = 5;
        loginLabel.setForeground(new Color(95, 131, 156));
        loginLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        container.add(loginLabel, gbc);

//  "Password" label position
        gbc.gridx = 1;
        gbc.gridy = 7;
        passwordLabel.setForeground(new Color(95, 131, 156));
        passwordLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        container.add(passwordLabel, gbc);

//  "Login" field position
        gbc.gridx = 1;
        gbc.gridy = 6;
        loginField.setPreferredSize(d);
        loginField.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
        container.add(loginField, gbc);

//  "Password" field position
        gbc.gridx = 1;
        gbc.gridy = 8;
        passwordField.setPreferredSize(d);
        passwordField.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
        container.add(passwordField, gbc);

//  "Build Version" label position
        gbc.gridx = 0;
        gbc.gridy = 10;
        buildVersionLabel.setForeground(Color.GRAY);
        buildVersionLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
        container.add(buildVersionLabel, gbc);

//  "Start Button" position
        gbc.gridx = 1;
        gbc.gridy = 9;
        startButton.setPreferredSize(d);
        startButton.setBounds(20, 20, 20, 20);
        startButton.setBackground(new Color(74, 126, 145));
        startButton.setFont(new java.awt.Font("Arial", Font.BOLD, 16));

        startButton.setForeground(Color.WHITE);
        startButton.setBorder(new LineBorder(redColor, 1, true));
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startButton.addActionListener(new ButtonEventListener());
        container.add(startButton, gbc);



//  Waiting animation position
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        container.add(waitingAnimation, gbc);

//  "Test is running" label position
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.weighty = 1;
        waitingLabel.setForeground(new Color(249, 255, 254));
        waitingLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        container.add(waitingLabel, gbc);

//  Main Window Background
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

//  Login/Password fields validation
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

//  Accept login/password
            if (loginFilled && passFilled) {
                int authorizePopupOption = 0;
                int mainConfirmationPopupOption = 0;
                JTextField field1 = new JTextField();
                JTextField field2 = new JTextField();

//  Show "Authorize Credentials" popup
                boolean transactionFailed = false;
                if (entityTypeComboBoxIndex == 0) {
                    field1.setText(browserSettings.authApiLoginId);
                    field2.setText(browserSettings.authTransactionKey);
                    Object[] message = {
                            "API Login ID:", field1,
                            "Transaction Key:                    ", field2,
                    };
                    authorizePopupOption = JOptionPane.showConfirmDialog(null, message, "Authorize.Net credentials", JOptionPane.OK_CANCEL_OPTION, 0, authorize);

//  Authorize credentials fields validation
                    String transactionWarning = "It seems you forgot to fill ";
                    if (field1.getText().length() > 0){
                        browserSettings.authApiLoginId = field1.getText();
                    } else {
                        transactionFailed = true;
                        transactionWarning += "'API Login ID'";
                    }
                    if (field2.getText().length() > 0){
                        browserSettings.authTransactionKey = field2.getText();
                        transactionWarning += " field.";
                    } else {
                        if(transactionFailed){
                            transactionWarning += " and 'Transaction Key' fields.";
                        } else {
                            transactionWarning += "'Transaction Key' field.";
                            transactionFailed = true;
                        }
                    }
                    if (authorizePopupOption == JOptionPane.YES_OPTION){
                        if (transactionFailed){
                            JOptionPane.showMessageDialog(null,
                                    transactionWarning + "\nOk, I'll give you another try.",
                                    "Warning",
                                    JOptionPane.PLAIN_MESSAGE, hmm);
                        }
                    }
//                    System.out.println(browserSettings.authApiLoginId + " " + browserSettings.authTransactionKey);
                }

//  Show "Lucky Confirmation" popup
                if (authorizePopupOption == JOptionPane.OK_OPTION && !transactionFailed) {
                    final String[] driverWarning = {""};
                    String infoMessage = "";
                    infoMessage += "Test is starting now\n\n";
                    infoMessage += "Selected Browser: " + browsersComboBox.getSelectedItem() + "\n";
                    infoMessage += "Selected Test: " + entityTypeComboBox.getSelectedItem() + "\n";
                    infoMessage += "Selected Environment: " + environmentsComboBox.getSelectedItem() + "\n\n";
                    infoMessage += "Performing the test will take some time. Please wait!\nMake a cup of tea or hug your cat :)\n\n";

                    startButton.setEnabled(false);
                    waitingLabel.setVisible(true);
                    waitingAnimation.setVisible(true);

                    mainConfirmationPopupOption = JOptionPane.showConfirmDialog(null, infoMessage, "Lucky Confirmation", JOptionPane.OK_CANCEL_OPTION, 0, icon);

                    final int finalMainConfirmationPopupOption = mainConfirmationPopupOption;
                    Runnable runnable = () -> {
                        if (finalMainConfirmationPopupOption == JOptionPane.OK_OPTION) {
                            try {
                                if (browserComboBoxIndex == 0) {
                                    driverWarning[0] += "Firefox";
                                    driver = new FirefoxDriver();

                                } else if (browserComboBoxIndex == 1) {
                                    driverWarning[0] += "Chrome";
                                    System.setProperty("webdriver.chrome.driver", "C:\\appFiles\\drivers\\chromedriver.exe");
                                    driver = new ChromeDriver();
                                }
                            } catch (IllegalStateException e1) {
                                exceptionStatus = true;
                                JOptionPane.showMessageDialog(null,
                                        driverWarning[0] + " WebDriver was not found",
                                        "Failed",
                                        JOptionPane.PLAIN_MESSAGE, sad);
                                startButton.setEnabled(true);
                                waitingLabel.setVisible(false);
                                waitingAnimation.setVisible(false);
                            }
//  Call "Browser Settings" class
                            browserSettings.setUp(environmentComboBoxIndex, browserComboBoxIndex, driver);

//  Generate Result message
                            String exceptionMessage = "";
                            String resultMessage = "";
                            resultMessage += "Oh boy, you are lucky.\n" + "\n" + "Test has been finished.\nNew ";
                            try {
                                if (entityTypeComboBoxIndex == 0) {
                                    setUpNewMerchant.setupNewMerchant(loginValue, password, driver);
                                    resultMessage += "Merchant '" + loginValue + "' has been configured\n";
                                } else if (entityTypeComboBoxIndex == 1) {
                                    jira3675_AddNewCustomerWithCreditCard.jira3675(loginValue, password, driver);
                                    resultMessage += "Customer has been created\n" + "\n";
                                    resultMessage += "Customer name is:\n" + jira3675_AddNewCustomerWithCreditCard.firstName + " " + jira3675_AddNewCustomerWithCreditCard.lastName;
                                } else if (entityTypeComboBoxIndex == 2) {
                                    jira3015_CreateProductAndBin.jira3015(loginValue, password, driver);
                                    resultMessage += "Product has been created\n" + "\n";
//                        resultMessage += "Product SKU is:" + jira3015_CreateProductAndBin.;
                                } else if (entityTypeComboBoxIndex == 3) {
                                    jira3006_merchantWarehouseAndBinCreation.jira3006(loginValue, password, driver);
                                    resultMessage += "Warehouse and Bin have been created\n" + "\n";
                                    resultMessage += "Warehouse name is: " + jira3006_merchantWarehouseAndBinCreation.warehouseName;
                                    resultMessage += "\nBin name is: " + jira3006_merchantWarehouseAndBinCreation.newBinName;
                                }
                            } catch (Exception e1) {
//                            credentialsValid = Boolean.getBoolean(loginPage.credentialsStatus);

//  Generate Failed message
                                exceptionStatus = true;
                                browserSettings.tearDown(driver);
                                startButton.setEnabled(true);
                                waitingLabel.setVisible(false);
                                waitingAnimation.setVisible(false);
//  Exceptions handler

//                            String exceptionName = e1.getClass().getSimpleName();
//
//                            if (exceptionName.equals("NoSuchWindowException")) {
//                                exceptionMessage += "Browser has been closed.";
//                            } else if (exceptionName.equals("NoSuchElementException")) {
//                                exceptionMessage += "Desired element was not found on the web page.";
//                            } else if (exceptionName.equals("TimeoutException")) {
//                                exceptionMessage += "Timeout has expired.";
//                            } else if (exceptionName.equals("WebDriverException")) {
//                                exceptionMessage += "WebDriverException.";
//                            } else if (exceptionName.equals("InvalidElementStateException")) {
//                                exceptionMessage += "InvalidElementStateException.";
//                            } else if (exceptionName.equals("NullPointerException")) {
//                                exceptionMessage += "NullPointerException.";
//                            } else
                                if (exceptionStatus) {
//                                if (credentialsValid) {
//                                    JOptionPane.showMessageDialog(null,
//                                            "Your credentials are not valid",
//                                            "Failed",
//                                            JOptionPane.PLAIN_MESSAGE, sad);
//                                } else {
                                    exceptionMessage += e1.getClass().getSimpleName();
                                    JOptionPane.showMessageDialog(null,
                                            "You are not lucky enough today.\n" + "  \n" + "Test has been stopped unexpectedly.\n" + "  \n" + "Reason:\n" + exceptionMessage,
                                            "Failed",
                                            JOptionPane.PLAIN_MESSAGE, sad);
//                                }
                                }
                            }

//  Run Complete message
                            if (!exceptionStatus) {
                                browserSettings.tearDown(driver);
                                startButton.setEnabled(true);
                                waitingLabel.setVisible(false);
                                waitingAnimation.setVisible(false);
                                JOptionPane.showMessageDialog(null,
                                        resultMessage,
                                        "Complete",
                                        JOptionPane.PLAIN_MESSAGE, success);
                            }
//  Behavior on Close/Cancel confirmation popup
                        }else if (finalMainConfirmationPopupOption == JOptionPane.CANCEL_OPTION || finalMainConfirmationPopupOption == JOptionPane.CLOSED_OPTION) {
                            startButton.setEnabled(true);
                            waitingLabel.setVisible(false);
                            waitingAnimation.setVisible(false);
                        }
                    };

                    Thread thread1 = new Thread(runnable);
                    thread1.start();
                } else if (authorizePopupOption == JOptionPane.CANCEL_OPTION) {
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}
