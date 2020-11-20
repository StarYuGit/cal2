package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button clean, brackets, quotient, division,
            seven, eight, nine, multi,
            four, five, six, sub,
            one, two, three, plus,
            plusorminus, zero, dot, equals;

    int bs_counter=0;
    TextView display, display1;
    TextView display2, display3;
    String temp="#",temp2="" , number="", showNumber="", one_result;
    String old_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clean:
                showNumber = "";
                number = "";
                temp = "#";
                bs_counter=0;
                display.setText(String.valueOf(0));
                display1.setText("");
                break;
            case R.id.brackets:
                if(!temp.equals("")){
                    if(temp.equals("#")){
                        temp = "";
                    } else {
                        number += temp;
                        temp = "";
                    }
                }
                if(!number.equals("")){
                    if (number.substring(number.length() - 1).equals("n")){
                        if(bs_counter == 0){
                            number += "×(";
                            showNumber += "×(";
                            bs_counter += 1;
                        } else {
                            number += ")";
                            showNumber += ")";
                            bs_counter -= 1;
                        }
                    } else if (number.substring(number.length() - 1).equals("(")){
                        number += "(";
                        showNumber += "(";
                        bs_counter += 1;
                    } else if (number.substring(number.length() - 1).equals(")")){
                        if(bs_counter != 0){
                            number += ")";
                            showNumber += ")";
                            bs_counter -= 1;
                        } else {
                            number += "×(";
                            showNumber += "×(";
                            bs_counter += 1;
                        }
                    } else if (number.substring(number.length() - 1).equals("o")){
                        number += "(";
                        showNumber += "(";
                        bs_counter += 1;
                    }
                } else {
                    temp = "";
                    number += "(";
                    showNumber += "(";
                    bs_counter += 1;
                }
                showNumber();
                break;
            case R.id.quotient: // %
                if (!temp.equals("#") ) {
                    if (temp.substring(temp.length() - 1).equals("n")){
                        temp += "%_";
                        showNumber += "%";
                        showNumber();
                    }
                }
                break;
            case R.id.division: // "÷"
                if(!temp.equals("#")){
                    number += temp;
                    temp = "";
                }
                if (!number.equals("")) {
                    if (number.substring(number.length() - 1).equals("o")) {
                        number = number.substring(0, number.length() - 2);
                        showNumber = showNumber.substring(0, showNumber.length() - 1);
                    }
                    if (number.substring(number.length() - 1).equals("("))
                        display1.setText("請輸入數字!");
                    else {
                        number += "÷o";
                        showNumber += "÷";
                        showNumber();
                    }
                } else
                    display1.setText("請輸入數字!");
                break;
            case R.id.seven:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "7n";
                showNumber += "7";
                showNumber();
                break;
            case R.id.eight:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "8n";
                showNumber += "8";
                showNumber();
                break;
            case R.id.nine:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "9n";
                showNumber += "9";
                showNumber();
                break;
            case R.id.multi: // "×"
                if(!temp.equals("#")){
                    number += temp;
                    temp = "";
                }
                if (!number.equals("")) {
                    if (number.substring(number.length() - 1).equals("o")) {
                        number = number.substring(0, number.length() - 2);
                        showNumber = showNumber.substring(0, showNumber.length() - 1);
                    }
                    if (number.substring(number.length() - 1).equals("("))
                        display1.setText("請輸入數字!");
                    else {
                        number += "×o";
                        showNumber += "×";
                        showNumber();
                    }
                } else
                    display1.setText("請輸入數字!");
                break;
            case R.id.four:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "4n";
                showNumber += "4";
                showNumber();
                break;
            case R.id.five:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "5n";
                showNumber += "5";
                showNumber();
                break;
            case R.id.six:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "6n";
                showNumber += "6";
                showNumber();
                break;
            case R.id.sub:// "－"
                if(!temp.equals("#")){
                    number += temp;
                    temp = "";
                }
                if (!number.equals("")) {
                    if (number.substring(number.length() - 1).equals("o")) {
                        number = number.substring(0, number.length() - 2);
                        showNumber = showNumber.substring(0, showNumber.length() - 1);
                    }
                    if (number.substring(number.length() - 1).equals("("))
                        display1.setText("請輸入數字!");
                    else {
                        number += "－o";
                        showNumber += "－";
                        showNumber();
                    }
                } else
                    display1.setText("請輸入數字!");
                break;
            case R.id.one:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "1n";
                showNumber += "1";
                showNumber();
                break;
            case R.id.two:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "2n";
                showNumber += "2";
                showNumber();
                break;
            case R.id.three:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "3n";
                showNumber += "3";
                showNumber();
                break;
            case R.id.plus:// "+"
                if(!temp.equals("#")){
                    number += temp;
                    temp = "";
                }
                if (!number.equals("")) {
                    if (number.substring(number.length() - 1).equals("o")) {
                        number = number.substring(0, number.length() - 2);
                        showNumber = showNumber.substring(0, showNumber.length() - 1);
                    }
                    if (number.substring(number.length() - 1).equals("("))
                        display1.setText("請輸入數字!");
                    else {
                        number += "+o";
                        showNumber += "+";
                        showNumber();
                    }
                } else
                    display1.setText("請輸入數字!");
                break;
            case R.id.plusorminus:
                if(temp2.equals("")){
                    temp2 = "(-";
                    temp = "";
                } else {
                    temp2 = "";
                    temp = "#";
                }
                showNumber();
                break;
            case R.id.zero:
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){ //如果前方是n
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        showNumber += "×";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        showNumber += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "0n";
                showNumber += "0";
                showNumber();
                break;
            case R.id.dot:
                if (temp.equals("#") ) {
                    temp = "";
                    temp += "0.";
                    showNumber += "0.";
                    showNumber();
                } else {
                    temp += ".";
                    showNumber += ".";
                    showNumber();
                }
                break;
            case R.id.equals:
                if (!temp.equals("#")) {
                    number += temp;
                    temp = "";
                }
                if(!number.equals("")) {
                    while(number.contains("(")&&number.contains(")")){
                        old_number = calculation(strip_to_arraylist(chk_word(number)));
                        number = number.replace(one_result, old_number);
                    }
                    display1.setText(calculation(strip_to_arraylist(number)));
                } else {
                    display1.setText("請選擇數字");
                }
                break;
        }
    }
    int first, last;
    public String chk_word(String str){
        if(str.contains("(")){
            first = str.indexOf("(");
            if(str.contains(")")){
                last = str.indexOf(")");
            } else {
                last = str.length();
            }
            one_result = str.substring(first, last +1);
            str = str.substring(first+1, last+1);
            return chk_word(str);
        } else {
            str = str.substring(0, str.length()-1);
            return str;
        }
    }
    public ArrayList<String> strip_to_arraylist(String str) {
        String[] temp;
        temp = str.split("n|o|_");
        List<String> numlist = Arrays.asList(temp);
        return new ArrayList<String>(numlist);
    }
    public String calculation (ArrayList num){
        while(num.contains("%")){
             for (int i = 0;i < num.size();i++){
                 if (num.get(i).equals("%")) {
                     double tmp = Double.parseDouble(num.get(i-1).toString());
                     tmp = tmp / 100;
                     num.set(i - 1, tmp);
                     num.remove(i);
                 }
             }
        }
        while(num.contains("×")) {
            for (int i = 0; i < num.size(); i++) {
                if (num.get(i).equals("×")) {
                    num.set(i - 1, operatormulti(num.get(i - 1).toString(), num.get(i + 1).toString()));
                    num.remove(i + 1);
                    num.remove(i);
                }
            }
        }
        while(num.contains("÷")) {
            for (int i = 0; i < num.size(); i++) {
                if (num.get(i).equals("÷")) {
                    num.set(i - 1,  operatordiv(num.get(i - 1).toString(), num.get(i + 1).toString()));
                    num.remove(i + 1);
                    num.remove(i);
                }
            }
        }
        while(num.contains("+")) {
            for (int i = 0; i < num.size(); i++) {
                if (num.get(i).equals("+")) {
                    num.set(i - 1, operatorPlus(num.get(i - 1).toString(), num.get(i + 1).toString()));
                    num.remove(i + 1);
                    num.remove(i);
                }
            }
        }
        while(num.contains("－")) {
            for (int i = 0; i < num.size(); i++) {
                if (num.get(i).equals("－")){
                    num.set(i-1, operatorsub(num.get(i-1).toString(), num.get(i+1).toString()));
                    num.remove(i+1);
                    num.remove(i);
                }
            }
        }
        return num.get(0).toString() +"n";
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
        display1.setText(String.format("%s%s%s", number, temp2, temp));
        display.setText(showNumber);
        display2.setText(temp);
    }
    public void init(){
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
        display2 = (TextView) findViewById(R.id.display2);
        //display3 = (TextView) findViewById(R.id.display3);

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


}
