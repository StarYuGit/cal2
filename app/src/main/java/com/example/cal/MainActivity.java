package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button clean, brackets, quotient, division,
            seven, eight, nine, multi,
            four, five, six, sub,
            one, two, three, plus,
            plusorminus, zero, dot, equals;
    TextView display,display1;
    String numTemp="#",showNumber="";
    ArrayList<String> numbers = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clean = (Button) findViewById(R.id.clean);
        brackets = (Button) findViewById(R.id.brackets);
        quotient = (Button) findViewById(R.id.quotient);
        division = (Button) findViewById(R.id.division);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        multi = (Button) findViewById(R.id.multi);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        sub = (Button) findViewById(R.id.sub);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        plus = (Button) findViewById(R.id.plus);
        plusorminus = (Button) findViewById(R.id.plusorminus);
        zero = (Button) findViewById(R.id.zero);
        dot = (Button) findViewById(R.id.dot);
        equals = (Button) findViewById(R.id.equals);

        display = (TextView) findViewById(R.id.display);
        display1 = (TextView) findViewById(R.id.display1);

        clean.setOnClickListener(this);
        brackets.setOnClickListener(this);
        quotient.setOnClickListener(this);
        division.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        multi.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        sub.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        plus.setOnClickListener(this);
        plusorminus.setOnClickListener(this);
        zero.setOnClickListener(this);
        dot.setOnClickListener(this);
        equals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clean:
                numbers.clear();
                showNumber = "";
                numTemp = "#";
                display.setText(String.valueOf(0));
                display1.setText("");
                break;
            case R.id.brackets:
                
                break;
            case R.id.quotient:
                if(!numTemp.equals("#")){
                    double tmp = Double.parseDouble(numTemp);
                    tmp = tmp / 100;
                    numTemp = String.valueOf(tmp);
                    showNumber += "%";
                    showNumber();
                }
                break;
            case R.id.division:
                if (!numTemp.equals("#") ) {
                    numbers.add(numTemp);
                    numTemp = "";
                    showNumber += "÷";
                    numbers.add("÷");
                    numbers.add(",");
                    showNumber();
                } else if (numbers.size() != 0) {
                    if (numbers.get(numbers.size() - 1).equals(",")){
                        numbers.set(numbers.size() - 2, "÷");
                        showNumber = showNumber.substring(0, showNumber.length() - 1);
                        showNumber += "÷";
                        showNumber();
                    }
                } else {
                    display1.setText("請選取數字");
                }
                break;
            case R.id.seven:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "7";
                showNumber += "7";
                showNumber();
                break;
            case R.id.eight:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "8";
                showNumber += "8";
                showNumber();
                break;
            case R.id.nine:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "9";
                showNumber += "9";
                showNumber();
                break;
            case R.id.multi:
                if (!numTemp.equals("#")) {
                    numbers.add(numTemp);
                    numTemp = "";
                    showNumber += "×";
                    numbers.add("×");
                    numbers.add(",");
                    showNumber();
                } else if (numbers.size() != 0) {
                    if (numbers.get(numbers.size() - 1).equals(",")){
                        numbers.set(numbers.size() - 2, "×");
                        showNumber = showNumber.substring(0, showNumber.length() - 1);
                        showNumber += "×";
                        showNumber();
                    }
                }  else {
                    display1.setText("請選取數字");
                }
                break;
            case R.id.four:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "4";
                showNumber += "4";
                showNumber();
                break;
            case R.id.five:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "5";
                showNumber += "5";
                showNumber();
                break;
            case R.id.six:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "6";
                showNumber += "6";
                showNumber();
                break;
            case R.id.sub:
                if (!numTemp.equals("#") ) {
                    numbers.add(numTemp);
                    numTemp = "";
                    showNumber += "－";
                    numbers.add("－");
                    numbers.add(",");
                    showNumber();
                } else if (numbers.size() != 0) {
                    if (numbers.get(numbers.size() - 1).equals(",")) {
                        numbers.set(numbers.size() - 2, "－");
                        showNumber = showNumber.substring(0, showNumber.length() - 1);
                        showNumber += "－";
                        showNumber();
                    }
                } else {
                    display1.setText("請選取數字");
                }

                break;
            case R.id.one:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "1";
                showNumber += "1";
                showNumber();
                break;
            case R.id.two:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "2";
                showNumber += "2";
                showNumber();
                break;
            case R.id.three:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#"))
                    numTemp = "";
                numTemp += "3";
                showNumber += "3";
                showNumber();
                break;
            case R.id.plus:
                if (!numTemp.equals("#") ) {
                    numbers.add(numTemp);
                    numTemp = "";
                    showNumber += "+";
                    numbers.add("+");
                    numbers.add(",");
                    showNumber();
                } else if (numbers.size() != 0) {
                    if (numbers.get(numbers.size() - 1).equals(",")){
                        numbers.set(numbers.size() - 2, "+");
                        showNumber = showNumber.substring(0, showNumber.length() - 1);
                        showNumber += "+";
                        showNumber();
                    }
                } else {
                    display1.setText("請選取數字");
                }
                break;
            case R.id.plusorminus:
                break;
            case R.id.zero:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#")) {
                    numTemp = "";
                }
                if (!numTemp.equals("#")){
                    numTemp += "0";
                    showNumber += "0";
                    showNumber();
                }
                break;
            case R.id.dot:
                if (numbers.size() != 0){
                    if (numbers.get(numbers.size() - 1).equals(","))
                        numbers.remove(numbers.size() - 1);
                }
                if (numTemp.equals("#")) {
                    numTemp = "";
                }
                if (numTemp == "") {
                    numTemp += "0.";
                    showNumber += "0.";
                    showNumber();
                } else {
                    numTemp += ".";
                    showNumber += ".";
                    showNumber();
                }
                break;
            case R.id.equals:
                if (numTemp.length() != 0) {
                    numbers.add(numTemp);
                    numTemp = "";
                }
                if (numbers.size() != 0){
                    if (!numbers.get(numbers.size() - 1).equals(",")) {
                        display.setText(calculation(numbers));
                        numbers.clear();
                        showNumber = "";
                        numTemp = "#";
                        display1.setText("");
                    } else {
                        display1.setText("請選擇數字");
                    }

                }
                break;
        }
    }
    public String calculation (ArrayList num){
        while(num.contains("×")) {
            for (int i = 0; i < num.size(); i++) {
                if (num.get(i).equals("×")) {
                    num.set(i - 1, operatormulti(num.get(i - 1).toString(), num.get(i + 1).toString()));
                    display.setText(num.get(i - 1).toString());
                    num.remove(i + 1);
                    num.remove(i);
                }
            }
        }
        while(numbers.contains("÷")) {
            for (int i = 0; i < num.size(); i++) {
                if (num.get(i).equals("÷")) {
                    num.set(i - 1, operatordiv(num.get(i - 1).toString(), num.get(i + 1).toString()));
                    display.setText(num.get(i - 1).toString());
                    num.remove(i + 1);
                    num.remove(i);
                }
            }
        }
        while(numbers.contains("+")) {
            for (int i = 0; i < num.size(); i++) {
                if (num.get(i).equals("+")) {
                    num.set(i - 1, operatorPlus(num.get(i - 1).toString(), num.get(i + 1).toString()));
                    display.setText(num.get(i - 1).toString());
                    num.remove(i + 1);
                    num.remove(i);
                }
            }
        }
        while(numbers.contains("－")) {
            for (int i = 0; i < num.size(); i++) {
                if (num.get(i).equals("－")){
                    num.set(i-1, operatorsub(num.get(i-1).toString(), num.get(i+1).toString()));
                    display.setText(num.get(i-1).toString());
                    num.remove(i+1);
                    num.remove(i);
                }
            }
        }
        return num.get(0).toString();
    }
    public String operatormulti(String i1, String i2){
        BigDecimal temp, temp1, temp2;
        BigDecimal[] tp;
        temp1 = new BigDecimal(i1);
        temp2 = new BigDecimal(i2);
        temp = temp1.multiply(temp2);
        tp = temp.divideAndRemainder(BigDecimal.valueOf(1));
        if (tp[1].doubleValue() == 0.0){
            return temp.stripTrailingZeros().toPlainString();
        } else {
            return String.valueOf(temp);
        }
    }
    public String operatordiv(String i1, String i2){
        BigDecimal temp, temp1, temp2;
        BigDecimal[] tp;
        temp1 = new BigDecimal(i1);
        temp2 = new BigDecimal(i2);
        temp = temp1.divide(temp2, 10, BigDecimal.ROUND_HALF_UP);
        tp = temp.divideAndRemainder(BigDecimal.valueOf(1));
        if (tp[1].doubleValue() == 0.0){
            return temp.stripTrailingZeros().toPlainString();
        } else {
            return String.valueOf(temp);
        }
    }
    public String operatorPlus(String i1, String i2){
        BigDecimal temp, temp1, temp2;
        BigDecimal[] tp;
        temp1 = new BigDecimal(i1);
        temp2 = new BigDecimal(i2);
        temp = temp1.add(temp2);
        tp = temp.divideAndRemainder(BigDecimal.valueOf(1));
        if (tp[1].doubleValue() == 0.0){
            return temp.stripTrailingZeros().toPlainString();
        } else {
            return String.valueOf(temp);
        }
    }
    public String operatorsub(String i1, String i2){
        BigDecimal temp, temp1, temp2;
        BigDecimal[] tp;
        temp1 = new BigDecimal(i1);
        temp2 = new BigDecimal(i2);
        temp = temp1.subtract(temp2);
        tp = temp.divideAndRemainder(BigDecimal.valueOf(1));
        if (tp[1].doubleValue() == 0.0){
            return temp.stripTrailingZeros().toPlainString();
        } else {
            return String.valueOf(temp);
        }
    }
    public void showNumber(){
        display.setText(showNumber);
    }
}