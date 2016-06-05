package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.Objects;

public class Controller extends Main implements KeyListener{


    public Label resultField;
    public Label operationField;
    public Button acButton;
    public TextField textField = new TextField();
    public AnchorPane allApp;
    public Button delButton;
    public Button plusMinusButton;
//    public Button divButton;
//    public Button multiplyButton;
//    public Button minusButton;
//    public Button plusButton;
//    public Button equalsButton;
    public Button dotButton;

    public Button zeroButton;
    public Button oneButton;
    public Button twoButton;
    public Button threeButton;
    public Button fourButton;
    public Button fiveButton;
    public Button sixButton;
    public Button sevenButton;
    public Button eightButton;
    public Button nineButton;

    private boolean plusForDigits = false;
    private boolean plusForEquals = false;
    private boolean minusForDigits = false;
    private boolean minusForEquals = false;
    private boolean multiplyForDigits = false;
    private boolean multiplyForEquals = false;
    private boolean divideForDigits = false;
    private boolean divideForEquals = false;
    private boolean equals = false;
    private boolean dotStatus = false;

    private String currentValue = "0";
    private String firstArgument = "0";
    private String secondArgument = "0";
    private double resultValue = 0;

    private int resultLength = 0;

    private float bufferValue = 0;

    private GridPane gridPane = new GridPane();

    public void keyEvent() {
//        textField.setOnKeyTyped(event -> {
//            if (event.getCode() == KeyCode.ENTER) {
//                resultField.setText("Did It");
//            }
//        });

        System.out.println("Key Event method");
        textField.setOnKeyPressed(event -> {
            System.out.println("Key Event lambda");
            if (event.getCode() == KeyCode.F1) {
                resultField.setText("Yes");
            }
        });
    }

    private void buttonClickAction(Button buttonName) {
        buttonName.setOnMousePressed(me -> {
            System.out.println("Mouse pressed");
            buttonName.setStyle("-fx-background-color: #FFFFFF;");
            //buttonName.setStyle("-fx-background-image: ");
            //buttonName.setStyle("-fx-border-color:  #555;");
        });
        buttonName.setOnMouseReleased(me -> {
            System.out.println("Mouse Released");
            buttonName.setStyle("-fx-background-color: #EEEEE0;");
            //buttonName.setStyle("-fx-border-color:  #555;");
        });
    }

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
//            resultField.setOnKeyPressed(event -> {
//                ScaleTransition scale = new ScaleTransition(Duration.seconds(1), resultField);
//                        resultField.setFont(Font.font("FreeMono", 30));
//                        scale.setFromX(2);
//                        scale.setFromY(2);
//                        scale.setToX(1);
//                        scale.setToY(1);
//                        scale.play();
//            }
//            );
        }else if (resultLength >= 12) {
            resultField.setFont(Font.font("FreeMono", 20));
        }else if (resultLength > 0 && resultLength < 6) {
            resultField.setFont(Font.font("FreeMono", 60));
        }
    }

    public void acButtonAction(ActionEvent actionEvent) {
        buttonClickAction(acButton);
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
        buttonClickAction(sevenButton);
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
        buttonClickAction(eightButton);
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
        buttonClickAction(nineButton);
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
        buttonClickAction(fourButton);
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
        buttonClickAction(fiveButton);
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
        buttonClickAction(sixButton);
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
        buttonClickAction(oneButton);
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
        buttonClickAction(twoButton);
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
        buttonClickAction(threeButton);
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
        buttonClickAction(zeroButton);
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
        buttonClickAction(dotButton);
        if (!dotStatus) {
            currentValue = resultField.getText();
            if (currentValue.endsWith(".")) {
                System.out.println("extra dot");
            } else if (Objects.equals(currentValue, "0")) {
                resultField.setText(currentValue + ".");
            } else if (Objects.equals(currentValue, currentValue)) {
                resultField.setText(currentValue + ".");
            }
            checkForResultLength();

            if (plusForDigits || minusForDigits || multiplyForDigits || divideForDigits) {
                makeOperationsFalse();
            }
            dotStatus = true;
        }
    }

    public void deleteButtonAction(ActionEvent actionEvent) {
        buttonClickAction(delButton);
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

        DecimalFormat df = new DecimalFormat("################.###");
        currentValue = df.format(resultValue);
        if (currentValue.endsWith(".0")) {
            currentValue = currentValue.replace(".0", "");
        }

        resultField.setText(currentValue);
        checkForResultLength();
        makeOperationsFalse();
        equals = true;
        dotStatus = false;
    }

    public void plusAction(ActionEvent actionEvent) {
        plusForDigits = true;
        plusForEquals = true;
        minusForEquals = false;
        multiplyForEquals = false;
        divideForEquals = false;
        dotStatus = false;
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
        dotStatus = false;
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
        dotStatus = false;
        operationField.setText("×");
        firstArgument = resultField.getText();
        currentValue = "0";
    }

    public void divideAction(ActionEvent actionEvent) {
        divideForDigits = true;
        divideForEquals = true;
        plusForEquals = false;
        minusForEquals = false;
        multiplyForEquals = false;
        dotStatus = false;
        operationField.setText("÷");
        firstArgument = resultField.getText();
        currentValue = "0";
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
//        int keyCode = e.getKeyCode();
//        if (keyCode == KeyEvent.) {
//
//        }
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
//        if (KeyEvent.getKeyText(e.getKeyCode()).equals(Config.left)) {
//            System.out.println("Tratata");
//        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {

    }
}