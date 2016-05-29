package sample;

import com.sun.javafx.css.converters.FontConverter;
import com.sun.javafx.font.FontResource;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.Objects;

public class Controller {

    public Label resultField;
    public Label operationField;
    public Button button;

    DropShadow shadow = new DropShadow();

    private boolean plusForDigits = false;
    private boolean plusForEquals = false;
    private boolean minusForDigits = false;
    private boolean minusForEquals = false;
    private boolean multiplyForDigits = false;
    private boolean multiplyForEquals = false;
    private boolean divideForDigits = false;
    private boolean divideForEquals = false;
    private boolean equals = false;

    private String currentValue = "0";
    private String firstArgument = "0";
    private String secondArgument = "0";
    private float resultValue = 0;

    private int resultLength = 0;

    private float bufferValue = 0;


    private void makeOperationsFalse() {
        plusForDigits = false;
        minusForDigits = false;
        multiplyForDigits = false;
        divideForDigits = false;
        equals = false;
    }

    private void checkForResultLength() {
        resultLength = currentValue.length();
        if (resultLength >= 6 && resultLength < 12) {
            resultField.setFont(Font.font("FreeMono", 30));
        }else if (resultLength >= 12) {
            resultField.setFont(Font.font("FreeMono", 20));
        }else if (resultLength > 0 && resultLength < 6) {
            resultField.setFont(Font.font("FreeMono", 60));
        }
    }

    public void acButtonAction(ActionEvent actionEvent) {
        resultField.setText("0");
        operationField.setText("");
        currentValue = "0";
        firstArgument = "0";
        secondArgument = "0";
        resultValue = 0;
        makeOperationsFalse();
        checkForResultLength();
    }

    public void sevenButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("7");
        } else resultField.setText(currentValue + "7");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("7");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void eightButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("8");
        } else resultField.setText(currentValue + "8");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("8");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void nineButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("9");
        } else resultField.setText(currentValue + "9");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("9");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void fourButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("4");
        } else resultField.setText(currentValue + "4");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("4");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void fiveButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("5");
        } else resultField.setText(currentValue + "5");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("5");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void sixButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("6");
        } else resultField.setText(currentValue + "6");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("6");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void oneButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("1");
        } else resultField.setText(currentValue + "1");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("1");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void twoButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("2");
        } else resultField.setText(currentValue + "2");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("2");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void threeButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("3");
        } else resultField.setText(currentValue + "3");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("3");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void zeroButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if (Objects.equals(currentValue, "0")) {
            resultField.setText("0");
        } else resultField.setText(currentValue + "0");

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            resultField.setText("0");
            makeOperationsFalse();
        }
        checkForResultLength();
    }

    public void dotButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        if(currentValue.endsWith(".")){
            System.out.println("extra dot");
        }else if (Objects.equals(currentValue, "0")) {
            resultField.setText(currentValue + ".");
        }else if(Objects.equals(currentValue, currentValue)) {
            resultField.setText(currentValue + ".");
        }
        checkForResultLength();

        if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
            makeOperationsFalse();
        }
    }

    public void deleteButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();
        resultLength = currentValue.length();
        if (resultLength == 1) {
            resultField.setText("0");
        }
        if (resultLength > 1) {
            currentValue = currentValue.substring(0, resultLength -1);
            resultField.setText(currentValue);
        }
        checkForResultLength();
    }

    public void plusMinusButtonAction(ActionEvent actionEvent) {
        currentValue = resultField.getText();

        bufferValue = Float.parseFloat(currentValue);
        bufferValue = -bufferValue;
        currentValue = Float.toString(bufferValue);
        if (currentValue.endsWith(".0")) {
            currentValue = currentValue.replace(".0", "");
        }
        resultField.setText(currentValue);
        checkForResultLength();
    }

    public void equalsAction(ActionEvent actionEvent) {
        operationField.setText("=");
        if (plusForEquals) {
            secondArgument = resultField.getText();
            resultValue = Float.parseFloat(firstArgument) + Float.parseFloat(secondArgument);
        }else if (minusForEquals) {
            secondArgument = resultField.getText();
            resultValue = Float.parseFloat(firstArgument) - Float.parseFloat(secondArgument);
        }else if (multiplyForEquals) {
            secondArgument = resultField.getText();
            resultValue = Float.parseFloat(firstArgument) * Float.parseFloat(secondArgument);
        }else if (divideForEquals) {
            secondArgument = resultField.getText();
            resultValue = Float.parseFloat(firstArgument) / Float.parseFloat(secondArgument);
        }

        currentValue = Float.toString(resultValue);
        if (currentValue.endsWith(".0")) {
            currentValue = currentValue.replace(".0", "");
        }

        resultField.setText(currentValue);
        checkForResultLength();
        makeOperationsFalse();
        equals = true;
    }

    public void plusAction(ActionEvent actionEvent) {
        plusForDigits = true;
        plusForEquals = true;
        minusForEquals = false;
        multiplyForEquals = false;
        divideForEquals = false;
        operationField.setText("+");
        firstArgument = resultField.getText();
        currentValue = "0";

    }

    public void minusAction(ActionEvent actionEvent) {
        minusForDigits = true;
        minusForEquals = true;
        plusForEquals = false;
        multiplyForEquals = false;
        divideForEquals = false;
        operationField.setText("-");
        firstArgument = resultField.getText();
        currentValue = "0";
    }

    public void multiplyAction(ActionEvent actionEvent) {
        multiplyForDigits = true;
        multiplyForEquals = true;
        plusForEquals = false;
        minusForEquals = false;
        divideForEquals = false;
        operationField.setText("x");
        firstArgument = resultField.getText();
        currentValue = "0";
    }

    public void divideAction(ActionEvent actionEvent) {
        divideForDigits = true;
        divideForEquals = true;
        plusForEquals = false;
        minusForEquals = false;
        multiplyForEquals = false;
        operationField.setText("/");
        firstArgument = resultField.getText();
        currentValue = "0";
    }
}