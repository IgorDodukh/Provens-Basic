package SmokeTests.UI;

/**
 * Created by Ihor on 7/17/2016.
 */
public class ProgressBar {

    public static void addProgressValue(int i) {
        SimpleGUI.progressBar.paintImmediately(0, 0, 200, 25);
        SimpleGUI.addProgressValue = SimpleGUI.addProgressValue + i;
        SimpleGUI.progressBar.setValue(SimpleGUI.addProgressValue);
//        SimpleGUI.progressBar.setString(SimpleGUI.addProgressValue + "%");
        SimpleGUI.waitingLabel.setText("Test is running... " + SimpleGUI.addProgressValue + "%");

    }
}
