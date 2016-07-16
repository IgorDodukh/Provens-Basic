package SmokeTests.UI;

import javax.swing.*;

/**
 * Created by Ihor on 7/16/2016.
 */
public class TestStatus {

    public void startTest(JButton startButton, JLabel waitingLabel, JLabel waitingAnimation) {
        startButton.setEnabled(false);
        waitingLabel.setVisible(true);
        waitingAnimation.setVisible(true);
    }

    public void stopTest(JButton startButton, JLabel waitingLabel, JLabel waitingAnimation) {
        startButton.setEnabled(true);
        waitingLabel.setVisible(false);
        waitingAnimation.setVisible(false);
    }
}
