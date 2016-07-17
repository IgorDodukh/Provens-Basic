package SmokeTests.UI;

/**
 * Created by igor on 05.06.16.
 */

import SmokeTests.Settings.BrowserSettings;
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

public class SimpleGUI extends JFrame {
    private WebDriver driver;
    private BrowserSettings browserSettings = new BrowserSettings();

    public static int addProgressValue = 0;

//  Main window elements
    private JButton startButton = new JButton("Start Test");
    private JLabel browserLabel = new JLabel("Select Browser");
    private JLabel entityTypeLabel = new JLabel("Select Test Type");
    private JLabel environmentLabel = new JLabel("Select Environment");
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JLabel buildVersionLabel = new JLabel("Build Version: 1.20 beta");
    private JLabel topSpaceLabel = new JLabel(" ");
    private JLabel middleSpaceLabel = new JLabel(" ");
    public static JLabel waitingLabel = new JLabel("Test is running... " + addProgressValue + "%");
    public static JProgressBar progressBar = new JProgressBar(0, 100);

//  Graphical resources
    private final ImageIcon animatedIcon = new ImageIcon("C:\\appFiles\\pic\\spinner.gif");
    private final BufferedImage appIcon = ImageIO.read(new File("C:\\appFiles\\pic\\high-performance-200x160.png"));
    private final BufferedImage background = ImageIO.read(new File("C:\\appFiles\\pic\\background.png"));
    private final ImageIcon sad = new ImageIcon("C:\\appFiles\\pic\\sad.png");
    private final ImageIcon authorize = new ImageIcon("C:\\appFiles\\pic\\authorize-net.png");
    private final ImageIcon icon = new ImageIcon("C:\\appFiles\\pic\\smile2.png");


    private final ImageIcon visaLogo = new ImageIcon("C:\\appFiles\\pic\\visa.png");
    private final ImageIcon masterCardLogo = new ImageIcon("C:\\appFiles\\pic\\mastercard.png");
    private final ImageIcon discoverLogo = new ImageIcon("C:\\appFiles\\pic\\discover.png");
    private final ImageIcon americanExpressLogo = new ImageIcon("C:\\appFiles\\pic\\American-Express.png");
    private final ImageIcon ccLogo = new ImageIcon("C:\\appFiles\\pic\\credit-card-logo.png");

    private JLabel waitingAnimation = new JLabel(new ImageIcon(String.valueOf(animatedIcon)));
    private JTextField loginField = new JTextField("newadmin@dydacomp.biz", 15);
    private JPasswordField passwordField = new JPasswordField("78qa22!#", 15);

    private String testCardNumber = "";

    private Dimension d = new Dimension(200,30);

    private JComboBox<String> browsersComboBox = new JComboBox<>();
    private JComboBox<String> entityTypeComboBox = new JComboBox<>();
    private JComboBox<String> environmentsComboBox = new JComboBox<>();

    private String[] browsers = {" Google Chrome", " Mozilla Firefox"};
    private String[] entityTypes = {" Configure Merchant", " Create Customer", " Create Product", " Create Supplier", " Create Warehouse & Bin", " Reorder the last Order"};
    private String[] environments = {" QA01", " QA03", " QA05", " Production (for mad guys)"};

    private boolean exceptionStatus = false;
    private int browserComboBoxIndex;
    private int environmentComboBoxIndex;
    private int entityTypeComboBoxIndex;

    static boolean loginFilled = false;
    static boolean passFilled = false;

    private Exception exceptionValue;

    private TestStatus testStatus = new TestStatus();
    private FieldsValidation fieldsValidation = new FieldsValidation();
    private DropdownValueDeterminer dropdownValueDeterminer = new DropdownValueDeterminer();

    static String resultMessage = "";

    private SimpleGUI() throws IOException {
        super("Secret app for our team :)");

//  Main app configs
        this.setBounds(800,400,500,448);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(appIcon);
        waitingAnimation.setVisible(false);
        waitingLabel.setVisible(false);
        progressBar.setVisible(false);


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
        gbc.insets = new Insets(13, 20, 2, 20);

//  Progress bar position
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        progressBar.setBackground(new Color(255, 255, 255));
        progressBar.setForeground(new Color(42, 67, 77));
        progressBar.setBorderPainted(false);
//        SimpleGUI.progressBar.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
//        SimpleGUI.progressBar.setStringPainted(true);
//        SimpleGUI.progressBar.setString(String.valueOf(addProgressValue) + "%");
        container.add(progressBar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
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

            browserComboBoxIndex = browsersComboBox.getSelectedIndex();
            environmentComboBoxIndex = environmentsComboBox.getSelectedIndex();
            entityTypeComboBoxIndex = entityTypeComboBox.getSelectedIndex();

            String login = loginField.getText();
            String password = String.valueOf(passwordField.getPassword());

//  Login/Password fields validation
            fieldsValidation.loginPassValidation(login, password, loginField, passwordField, loginLabel, passwordLabel);

//  Accept login/password
            if (loginFilled && passFilled) {
                int popupOption = 0;
                int mainConfirmationPopupOption = 0;

//  Show "Authorize Credentials" popup

                boolean transactionFailed = false;
                if (entityTypeComboBoxIndex == 0) {

                    JTextField field1 = new JTextField();
                    JTextField field2 = new JTextField();
                    field1.setText(BrowserSettings.authApiLoginId);
                    field2.setText(BrowserSettings.authTransactionKey);
                    Object[] message = {
                            "API Login ID:", field1,
                            "Transaction Key:                    ", field2,
                    };
                    popupOption = JOptionPane.showConfirmDialog(
                            null,
                            message,
                            "Authorize.Net credentials",
                            JOptionPane.OK_CANCEL_OPTION,
                            0,
                            authorize);

//  Authorize credentials fields validation
                    String transactionWarning = "It seems you forgot to fill ";
                    if (field1.getText().length() > 0){
                        BrowserSettings.authApiLoginId = field1.getText();
                    } else {
                        transactionFailed = true;
                        transactionWarning += "'API Login ID'";
                    }
                    if (field2.getText().length() > 0){
                        BrowserSettings.authTransactionKey = field2.getText();
                        transactionWarning += " field.";
                    } else {
                        if(transactionFailed){
                            transactionWarning += " and 'Transaction Key' fields.";
                        } else {
                            transactionWarning += "'Transaction Key' field.";
                            transactionFailed = true;
                        }
                    }

                    if (popupOption == JOptionPane.YES_OPTION){
                        if (transactionFailed){
                            GeneratePopupBox.hmmPopupBox(transactionWarning);
                        }
                    }

//  Show "Credit Card types" popup
                } else if (entityTypeComboBoxIndex == 1) {

                    final ButtonGroup buttonGroup = new ButtonGroup();
                    final JRadioButtonMenuItem visaButton = new JRadioButtonMenuItem(visaLogo);
                    final JRadioButtonMenuItem masterCardButton = new JRadioButtonMenuItem(masterCardLogo);
                    final JRadioButtonMenuItem americanExpressButton = new JRadioButtonMenuItem(americanExpressLogo);
                    final JRadioButtonMenuItem discoverButton = new JRadioButtonMenuItem(discoverLogo);

                    buttonGroup.add(visaButton);
                    buttonGroup.add(masterCardButton);
                    buttonGroup.add(americanExpressButton);
                    buttonGroup.add(discoverButton);

                    visaButton.setSelected(true);

                    Object[] message = {
                            "Choose preferred Card type: \n\n",
                            visaButton, masterCardButton, americanExpressButton, discoverButton
                    };

                    popupOption = JOptionPane.showConfirmDialog(
                            null,
                            message,
                            "Select Credit Card type",
                            JOptionPane.DEFAULT_OPTION, 0, ccLogo);

                    if (popupOption == JOptionPane.YES_OPTION){
                        if (visaButton.isSelected()) {
                            testCardNumber = BrowserSettings.visaTestCardNumber;
                        } else if (masterCardButton.isSelected()) {
                            testCardNumber = BrowserSettings.masterCardTestCardNumber;
                        } else if (americanExpressButton.isSelected()) {
                            testCardNumber = BrowserSettings.americanExpressTestCardNumber;
                        } else if (discoverButton.isSelected()) {
                            testCardNumber = BrowserSettings.discoverTestCardNumber;
                        }
                    }
                }

//  Show "Lucky Confirmation" popup
                if (popupOption == JOptionPane.OK_OPTION && !transactionFailed) {
                    final String[] driverWarning = {""};
//                    progressBar.setString(String.valueOf(addProgressValue) + "%");
                    waitingLabel.setText("Test is running... 0%");
                    String infoMessage = "";
                    infoMessage += "Test is starting now\n\n";
                    infoMessage += "Selected Browser: " + browsersComboBox.getSelectedItem() + "\n";
                    infoMessage += "Selected Test: " + entityTypeComboBox.getSelectedItem() + "\n";
                    infoMessage += "Selected Environment: " + environmentsComboBox.getSelectedItem() + "\n\n";
                    infoMessage += "Performing the test will take some time. Please wait!\nMake a cup of tea or hug your cat :)\n\n";

                    mainConfirmationPopupOption =  JOptionPane.showConfirmDialog(
                            null,
                            infoMessage,
                            "Lucky Confirmation",
                            JOptionPane.OK_CANCEL_OPTION,
                            0,
                            icon);

                    testStatus.startTest(startButton, waitingLabel, waitingAnimation, progressBar);
//  Start execution time counter
                    ExecutionTimeCounter.startCounter();

                    final int finalMainConfirmationPopupOption = mainConfirmationPopupOption;
                    final String[] driverExceptionMessage = {""};
// Start Thread
                    Runnable runnable = () -> {
                        if (finalMainConfirmationPopupOption == JOptionPane.OK_OPTION) {
                            try {
                                if (browserComboBoxIndex == 0) {
                                    driverWarning[0] += "Chrome";
                                    System.setProperty("webdriver.chrome.driver", "C:\\appFiles\\drivers\\chromedriver.exe");
                                    driver = new ChromeDriver();

                                } else if (browserComboBoxIndex == 1) {
                                    driverWarning[0] += "Firefox";
                                    driver = new FirefoxDriver();
                                }
                            } catch (Exception e1) {
                                exceptionStatus = true;
                                testStatus.stopTest(startButton, waitingLabel, waitingAnimation, progressBar);

                                if (!Objects.equals(e1.getClass().getSimpleName(), "SessionNotCreatedException")){
                                    driverExceptionMessage[0] += " session has been stopped unexpectedly.";
                                } else if (!Objects.equals(e1.getClass().getSimpleName(), "IllegalStateException")){
                                    driverExceptionMessage[0] += " WebDriver was not found";
                                } else {
                                    driverExceptionMessage[0] += " browser has been stopped unexpectedly.";
                                }
                                JOptionPane.showMessageDialog(null,
                                        driverWarning[0] + driverExceptionMessage[0],
                                        "Failed. Running time: " + ExecutionTimeCounter.executionTime,
                                        JOptionPane.PLAIN_MESSAGE, sad);
                            }
//  Call "Browser Settings" class
                            browserSettings.setUp(environmentComboBoxIndex, browserComboBoxIndex, driver);

//  Select test + Generate Result message
                            try {
                                dropdownValueDeterminer.entityTypeDropdown(entityTypeComboBoxIndex, login, password, testCardNumber, driver);
                            } catch (Exception e1) {
                                exceptionValue = e1;
                                exceptionStatus = true;
                                if (!Objects.equals(e1.getClass().getSimpleName(), "NoSuchWindowException")) {
                                    browserSettings.tearDown(driver);
                                }
// Show exception popup box
                            } finally {
                                ExecutionTimeCounter.stopCounter();
                                if (exceptionStatus) {
                                    testStatus.stopTest(startButton, waitingLabel, waitingAnimation, progressBar);
                                    GeneratePopupBox.exceptionPopupBox(exceptionValue);
                                }
                            }
//  Run Complete message
                            if (!exceptionStatus) {
                                browserSettings.tearDown(driver);
                                testStatus.stopTest(startButton, waitingLabel, waitingAnimation, progressBar);
                                GeneratePopupBox.successPopupBox(resultMessage);
                            }
//  Behavior on Close/Cancel confirmation popup
                        }else if (finalMainConfirmationPopupOption == JOptionPane.CANCEL_OPTION || finalMainConfirmationPopupOption == JOptionPane.CLOSED_OPTION) {
                            testStatus.stopTest(startButton, waitingLabel, waitingAnimation, progressBar);
                        }
                    };

                    Thread thread1 = new Thread(runnable);
                    thread1.start();
                } else if (popupOption == JOptionPane.CANCEL_OPTION) {
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}
