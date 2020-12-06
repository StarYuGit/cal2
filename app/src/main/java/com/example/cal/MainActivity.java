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
    TextView display, display2;
    TextView display3, display4, display5, display6;
    String temp="#",temp2="" , number="", one_result;
    String showNumber="", show_temp="";
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
            case R.id.clean: // C
                init_var();
                break;
            case R.id.brackets: // ()
                number += temp2;
                temp2 = "";
                temp_to_number();
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
                            temp += "×(";
                            show_temp += "×(";
                            bs_counter += 1;
                        } else {
                            temp += ")";
                            show_temp += ")";
                            bs_counter -= 1;
                        }
                    } else if (number.substring(number.length() - 1).equals("(")){
                        temp += "(";
                        show_temp += "(";
                        bs_counter += 1;
                    } else if (number.substring(number.length() - 1).equals(")")){
                        if(bs_counter != 0){
                            temp += ")";
                            show_temp += ")";
                            bs_counter -= 1;
                        } else {
                            temp += "×(";
                            show_temp += "×(";
                            bs_counter += 1;
                        }
                    } else if (number.substring(number.length() - 1).equals("o")){
                        temp += "(";
                        show_temp += "(";
                        bs_counter += 1;
                    }
                } else {
                    temp += "(";
                    show_temp += "(";
                    bs_counter += 1;
                }
                showNumber();
                break;
            case R.id.quotient: // %
                temp_to_number();
                if (!temp.equals("#") ) {
                    if (temp.substring(temp.length() - 1).equals("n")){
                        temp += "%_";
                        show_temp += "%";
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
                        display2.setText("請輸入數字!");
                    else {
                        number += "÷o";
                        show_temp += "÷";
                        showNumber();
                    }
                } else
                    display2.setText("請輸入數字!");
                break;
            case R.id.seven: // 7
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if(temp.equals("(")||temp.equals(")")){
                    temp_to_number();
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    }
                    if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                    if (temp.substring(temp.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "7n";
                show_temp += "7";
                showNumber();
                break;
            case R.id.eight: // 8
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if(temp.equals("(")||temp.equals(")")){
                    temp_to_number();
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    }
                    if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                    if (temp.substring(temp.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "8n";
                show_temp += "8";
                showNumber();
                break;
            case R.id.nine: // 9
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if(temp.equals("(")||temp.equals(")")){
                    temp_to_number();
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    }
                    if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                    if (temp.substring(temp.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "9n";
                show_temp += "9";
                showNumber();
                break;
            case R.id.multi: // "×"
                temp_to_number();
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
                        display2.setText("請輸入數字!");
                    else {
                        number += "×o";
                        show_temp += "×";
                        showNumber();
                    }
                } else
                    display2.setText("請輸入數字!");
                break;
            case R.id.four: // 4
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
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }

                temp += "4n";
                show_temp += "4";
                showNumber();
                break;
            case R.id.five: // 5
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if(temp.equals("(")||temp.equals(")")){
                    temp_to_number();
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    }
                    if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                    if (temp.substring(temp.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "5n";
                show_temp += "5";
                showNumber();
                break;
            case R.id.six: // 6
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if(temp.equals("(")||temp.equals(")")){
                    temp_to_number();
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    }
                    if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                    if (temp.substring(temp.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "6n";
                show_temp += "6";
                showNumber();
                break;
            case R.id.sub:// "－"
                temp_to_number();
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
                        display2.setText("請輸入數字!");
                    else {
                        number += "－o";
                        show_temp += "－";
                        showNumber();
                    }
                } else
                    display2.setText("請輸入數字!");
                break;
            case R.id.one: // 1
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if(temp.equals("(")||temp.equals(")")){
                    temp_to_number();
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    }
                    if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                    if (temp.substring(temp.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "1n";
                show_temp += "1";
                showNumber();
                break;
            case R.id.two: // 2
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if(temp.equals("(")||temp.equals(")")){
                    temp_to_number();
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    }
                    if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                    if (temp.substring(temp.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "2n";
                show_temp += "2";
                showNumber();
                break;
            case R.id.three: // 3
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if(temp.equals("0n")){
                    temp = "";
                    showNumber = showNumber.substring(0, showNumber.length() - 1);
                }
                if(temp.equals("(")||temp.equals(")")){
                    temp_to_number();
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length() - 1);
                    }
                    if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                    if (temp.substring(temp.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "3n";
                show_temp += "3";
                showNumber();
                break;
            case R.id.plus: // "+"
                temp_to_number();
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
                        display2.setText("請輸入數字!");
                    else {
                        number += "+o";
                        show_temp += "+";
                        showNumber();
                    }
                } else
                    display2.setText("請輸入數字!");
                break;
            case R.id.plusorminus: // +-
                if(temp.equals("#")){
                    if(temp2.equals("")){
                        temp2 = "(-";
                        temp = "";
                        bs_counter += 1;
                    } else if (temp2.equals("(-")){
                        temp2 = "";
                        temp = "#";
                        bs_counter -=1;
                    }
                } else {
                    if(temp2.equals("")){
                        temp2 = "(-";
                        bs_counter += 1;
                    } else if (temp2.equals("(-")){
                        temp2 = "";
                        bs_counter -= 1;
                    }
                }
                display.setText(String.format("%s%s%s", showNumber, temp2, temp));
                break;
            case R.id.zero: // 0
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                }
                if (!temp.equals("")){ //如果前方是n
                    if (temp.substring(temp.length()-1).equals("n")){ //如果前方是n
                        temp = temp.substring(0, temp.length() - 1);
                    } else if (temp.substring(temp.length()-1).equals("_")){
                        temp += "×o";
                        show_temp += "×";
                    }
                }
                if (!number.equals("")){
                    if (number.substring(number.length()-1).equals(")")){
                        temp += "×o";
                        show_temp += "×";
                        number += temp;
                        temp = "";
                    }
                }
                temp += "0n";
                show_temp += "0";
                showNumber();
                break;
            case R.id.dot: // .
                if (temp.equals("#") ) {
                    temp = "";
                    temp += "0.";
                    show_temp += "0.";
                    showNumber();
                } else {
                    if (temp.substring(temp.length()-1).equals("n")){
                        temp = temp.substring(0, temp.length()-1);
                    }
                    temp += ".";
                    show_temp += ".";
                    showNumber();
                }
                break;
            case R.id.equals: // =
                temp_to_number();
                if(bs_counter != 0){
                    number += temp;
                    for (int i=0;i<bs_counter;i++){
                        number += ")";
                    }
                }
                if(!number.equals("")) {
                    if (number.substring(number.length()-1).equals(".")){
                        number = number.substring(0, number.length() - 1);
                    }
                    while(number.contains("(")&&number.contains(")")){
                        old_number = calculation(strip_to_arraylist(chk_word(number)));
                        number = number.replace(one_result, old_number);
                    }
                    display.setText(calculation(strip_to_arraylist(number)));
                    showNumber = "";
                    show_temp = "";
                    number = "";
                    temp2 = "";
                    temp = "#";
                    bs_counter=0;
                    display2.setText("");
                } else {
                    display2.setText("請選擇數字");

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
        while(num.contains("-")){
            for (int i = 0;i < num.size();i++){
                if (num.get(i).equals("-")) {
                    num.set(i , operatorplusorminus(num.get(i + 1).toString()));
                    num.remove(i + 1);
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
        if (number.contains("(")){
            return num.get(0).toString() +"n";
        } else {
            return num.get(0).toString();
        }
    }
    public String operatorplusorminus(String i2){
        BigDecimal temp, temp1, temp2;
        temp1 = new BigDecimal("0");
        temp2 = new BigDecimal(i2);
        temp = temp1.subtract(temp2);
        return String.valueOf(temp);
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
        display.setText(String.format("%s%s%s", showNumber, temp2, show_temp));
        display2.setText(String.format("%s%s%s", number, temp2, temp));
        display3.setText(String.format("number:%s", number));
        display4.setText(String.format("temp:%s", temp));
        display5.setText(String.format("temp2:%s", temp2));
        display6.setText(String.format("show:%s", showNumber));


    }
    public void temp_to_number() {
        if (!temp.equals("#")) {
            show_temp += show_temp;
            show_temp = "";
            number += temp;
            temp = "";
        }
    }
    public void init_var(){
        showNumber = "";
        show_temp = "";
        number = "";
        temp2 = "";
        temp = "#";
        bs_counter=0;
        display.setText(String.valueOf(0));
        display2.setText("");
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
        display2 = (TextView) findViewById(R.id.display2);
        display3 = (TextView) findViewById(R.id.display3);
        display4 = (TextView) findViewById(R.id.display4);
        display5 = (TextView) findViewById(R.id.display5);
        display6 = (TextView) findViewById(R.id.display6);

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
