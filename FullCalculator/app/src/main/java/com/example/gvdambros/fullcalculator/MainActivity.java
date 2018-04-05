package com.example.gvdambros.fullcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView txtCalculation, txtResult;

    private enum OPERATOR {
        PLUS ("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), EQUAL("=");

        private final String text;

        OPERATOR(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }

    }

    private String currentNumber, numberAtLeft, numberAtRight;
    private OPERATOR currentOperator;
    private Integer calculationResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationResult = 0;
        currentOperator = null;
        numberAtRight = "";
        numberAtLeft = "";

        txtCalculation = findViewById(R.id.txtCalculation);
        txtResult = findViewById(R.id.txtResult);

        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnZero).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnOne).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnTwo).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnThree).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnFour).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnFive).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSix).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSeven).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnEight).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnNine).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMinus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.btnClear):
                clearIsTapped();
                break;
            case(R.id.btnZero):
                numberIsTapped(0);
                break;
            case(R.id.btnOne):
                numberIsTapped(1);
                break;
            case(R.id.btnTwo):
                numberIsTapped(2);
                break;
            case(R.id.btnThree):
                numberIsTapped(3);
                break;
            case(R.id.btnFour):
                numberIsTapped(4);
                break;
            case(R.id.btnFive):
                numberIsTapped(5);
                break;
            case(R.id.btnSix):
                numberIsTapped(6);
                break;
            case(R.id.btnSeven):
                numberIsTapped(7);
                break;
            case(R.id.btnEight):
                numberIsTapped(8);
                break;
            case(R.id.btnNine):
                numberIsTapped(9);
                break;
            case(R.id.btnPlus):
                operatorIsTapped(OPERATOR.PLUS);
                break;
            case(R.id.btnMinus):
                operatorIsTapped(OPERATOR.MINUS);
                break;
            case(R.id.btnMultiply):
                operatorIsTapped(OPERATOR.MULTIPLY);
                break;
            case(R.id.btnDivide):
                operatorIsTapped(OPERATOR.DIVIDE);
                break;
            case (R.id.btnEqual):
                operatorIsTapped(OPERATOR.EQUAL);
                break;
        }
    }

    private void clearIsTapped() {
        currentNumber = "";
        calculationResult = 0;
        currentOperator = null;
        numberAtRight = "";
        numberAtLeft = "";
        txtResult.setText("");
        txtCalculation.setText("");
    }

    private void numberIsTapped(int tappedNumber){
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtCalculation.setText(currentNumber);
    }

    private void operatorIsTapped(OPERATOR tappedOperator){

        if(currentOperator != null && currentNumber != "") {
            numberAtRight = currentNumber;
            currentNumber = "";

                switch (currentOperator) {
                    case PLUS:
                        calculationResult = Integer.parseInt(numberAtLeft) +
                                Integer.parseInt(numberAtRight);
                        break;
                    case MINUS:
                        calculationResult = Integer.parseInt(numberAtLeft) -
                                Integer.parseInt(numberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult = Integer.parseInt(numberAtLeft) *
                                Integer.parseInt(numberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Integer.parseInt(numberAtLeft) /
                                Integer.parseInt(numberAtRight);
                        break;
                }
                if(tappedOperator != OPERATOR.EQUAL) {
                    numberAtLeft = String.valueOf(calculationResult);;
                    currentOperator = tappedOperator;
                    txtResult.setText(String.valueOf(calculationResult) + tappedOperator.toString());
                    txtCalculation.setText(String.valueOf(calculationResult) + tappedOperator.toString());
                    currentNumber = "";
                }
                else {
                    txtResult.setText(String.valueOf(calculationResult));
                    txtCalculation.setText(String.valueOf(calculationResult));
                    currentNumber = String.valueOf(calculationResult);
                    currentOperator = null;
                }


        }
        if(currentOperator == null && currentNumber != "")  {
            if(tappedOperator != OPERATOR.EQUAL){
                numberAtLeft = currentNumber;
                currentOperator = tappedOperator;
                txtCalculation.setText(currentNumber + tappedOperator.toString());
                txtResult.setText(currentNumber + tappedOperator.toString());
                currentNumber = "";
            }
        }



    }
}
