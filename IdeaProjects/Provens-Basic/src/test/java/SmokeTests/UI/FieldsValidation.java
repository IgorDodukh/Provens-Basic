package SmokeTests.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static javax.swing.BorderFactory.createLineBorder;

/**
 * Created by Ihor on 7/13/2016.
 */
public class FieldsValidation {

    public void loginPassValidation(String loginValue, String password, JTextField loginField,
                                           JPasswordField passwordField, JLabel loginLabel, JLabel passwordLabel) {
        if (Objects.equals(loginValue, "")){
            loginField.setBorder(createLineBorder(Color.RED));
            loginLabel.setForeground(Color.RED);
            SimpleGUI.loginFilled = false;
        } else if (!Objects.equals(loginValue, "")) {
            loginField.setBorder(createLineBorder(Color.decode("#5f839c")));
            loginLabel.setForeground(Color.decode("#5f839c"));
            SimpleGUI.loginFilled = true;
        }
        if (Objects.equals(password, "")) {
            passwordField.setBorder(createLineBorder(Color.RED));
            passwordLabel.setForeground(Color.RED);
            SimpleGUI.passFilled = false;
        } else if (!Objects.equals(password, "")) {
            passwordField.setBorder(createLineBorder(Color.decode("#5f839c")));
            passwordLabel.setForeground(Color.decode("#5f839c"));
            SimpleGUI.passFilled = true;
        }
    }

//    public void authorizeValidation(String transactionWarning, JTextField field1, JTextField field2, boolean transactionFailed) {
//
//        transactionWarning = "It seems you forgot to fill ";
//
//        if (field1.getText().length() > 0){
//            BrowserSettings.authApiLoginId = field1.getText();
//        } else {
//            transactionFailed = true;
//            transactionWarning += "'API Login ID'";
//        }
//        if (field2.getText().length() > 0){
//            BrowserSettings.authTransactionKey = field2.getText();
//            transactionWarning += " field.";
//        } else {
//            if(transactionFailed){
//                transactionWarning += " and 'Transaction Key' fields.";
//            } else {
//                transactionWarning += "'Transaction Key' field.";
//                transactionFailed = true;
//            }
//        }
//    }
}
