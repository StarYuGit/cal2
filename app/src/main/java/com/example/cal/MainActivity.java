package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
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
    String[] delchar_temp = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    @Override
    public boolean onLongClick(View v) {
        temp_to_number();
        if(!number.equals("")){
            if(v.getId() == R.id.clean){
                init_var();
            }
        }

        return true;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clean: // C
                if(!show_temp.equals("")){
                    showNumber += show_temp;
                }
                showNumber = del_shownumber(showNumber);
                temp = del_number(temp);
                display.setText(showNumber);
                if(temp.equals("")){
                    delchar_temp = del_char(number);
                    number = delchar_temp[0];
                    temp = delchar_temp[1];
                    showNumber();
                }

                break;
            case R.id.brackets: // ()
                if(temp2.equals("(-")){
                    number += temp2;
                    showNumber += temp2;
                    temp2 = "";
                }
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
                            temp += "×o(";
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
                            temp += "×o(";
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
                if (temp.equals("#")) {
                    display2.setText("請輸入數字");
                } else {
                    if(!temp.equals("")){
                        if (temp.substring(temp.length() - 1).equals("n")) {
                            temp += "%_";
                            show_temp += "%";
                            showNumber();
                        }
                    }
                }
                if(temp.equals("")){
                    if(!number.equals("")){
                        number += "%_";
                        show_temp += "%";
                        showNumber();
                    }
                }
                break;
            case R.id.division: // "÷"
                button_operator("÷");
                break;
            case R.id.seven: // 7
                button_number("7");
                break;
            case R.id.eight: // 8
                button_number("8");
                break;
            case R.id.nine: // 9
                button_number("9");
                break;
            case R.id.multi: // "×"
                button_operator("×");
                break;
            case R.id.four: // 4
                button_number("4");
                break;
            case R.id.five: // 5
                button_number("5");
                break;
            case R.id.six: // 6
                button_number("6");
                break;
            case R.id.sub:// "－"
                button_operator("－");
                break;
            case R.id.one: // 1
                button_number("1");
                break;
            case R.id.two: // 2
                button_number("2");
                break;
            case R.id.three: // 3
                button_number("3");
                break;
            case R.id.plus: // "+"
                button_operator("+");
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
                display5.setText(String.format("show_temp:%s[temp2:%s]", show_temp, temp2));
                break;
            case R.id.zero: // 0
                if (temp.equals("#")) { //如果是變數沒有使用過
                    temp = "";
                    temp += "0ns";
                    show_temp += "0";
                    showNumber();
                }
                if (!temp.equals("0ns"))
                    button_number("0");
                break;
            case R.id.dot: // .
                if (temp.equals("0ns") ) {
                    temp = "";
                    show_temp = "";
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
                if(!number.equals("")) {
                    switch (number.substring(number.length()-1)){
                        case "o":
                        case "(":
                            display2.setText("請選擇數字");
                            break;
                        case ".":
                            number = number.substring(0, number.length() - 1);
                        default:
                            if(bs_counter != 0){
                                number += temp;
                                for (int i=0;i<bs_counter;i++){
                                    number += ")";
                                }
                            }
                            while (number.contains("(") && number.contains(")")) {
                                old_number = calculation(strip_to_arraylist(chk_word(number)));
                                number = number.replace(one_result, old_number);
                            }
                            temp = calculation(strip_to_arraylist(number));
                            if (temp.contains(".")) {
                                while (temp.substring(temp.length() - 1).equals("0")) {
                                    temp = temp.substring(0, temp.length() - 1);
                                }
                            }
                            if (temp.substring(temp.length() - 1).equals("n"))
                                showNumber = temp.substring(0, temp.length() - 1);
                            display.setText(showNumber);
                            display2.setText(temp);
                            number = "";
                            show_temp = "";
                            temp2 = "";
                            bs_counter = 0;
                            break;
                    }
                } else
                    display2.setText("請選擇數字");
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
        return num.get(0).toString() +"n";
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
    public String[] del_char(String str) {
        String[] temp;
        String[] two_number = new String[2];
        String str_temp = "";
        if (!str.equals("")) {
            if (str.contains("o"))
                str = str.replace("o", "o,");
            if (str.contains("n"))
                str = str.replace("n", "n,");
            if (str.contains("_"))
                str = str.replace("_", "_,");
            if (str.contains("("))
                str = str.replace("(", ",(,");
            if (str.contains(")"))
                str = str.replace(")", ",),");
            if (str.contains(",")) {

                temp = str.split(",");

                ArrayList<String> num = new ArrayList<String>(Arrays.asList(temp));
                two_number[1] = num.get(num.size() - 1);
                num.remove(num.size() - 1);
                for (String s : num) {
                    str_temp += s;
                }
                two_number[0] = str_temp;
            }
            return two_number;
        } else {
            two_number[1] = "";
            two_number[0] = "0";
            return two_number;
        }
    }



    public void button_operator(String operator) {
        if(temp2.equals("(-")){
            number += temp2;
            showNumber += temp2;
            temp2 = "";
        }
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
                temp += operator;
                temp += "o";
                show_temp += operator;
                showNumber();
            }
        } else
            display2.setText("請輸入數字!");
    }
    public void button_number(String num){
        int number_counter = 0;
        display2.setText("");
        if (!temp.equals("")){
            switch (temp.substring(temp.length()-1)){
                case "#":
                    temp = "";
                    break;
                case "0ns":
                    temp = "";
                    show_temp = "";
                    break;
                case "(":
                    temp_to_number();
                    break;
                case "n":
                    temp = temp.substring(0, temp.length() - 1);
                    break;
                case "o":
                    number += temp;
                    showNumber += show_temp;
                    show_temp = "";
                    temp = "";
                    break;
                case "_":
                case ")":
                    temp += "×o";
                    show_temp += "×";
                    number += temp;
                    temp = "";
                    break;
            }
        }
        temp += num;
        temp += "n";
        show_temp += num;
        number_counter += 1;
        showNumber();
    }
    public void showNumber(){
        display.setText(String.format("%s%s%s", showNumber, temp2, show_temp));
        int offset = display.getLineCount() * display.getLineHeight();
        if(offset>display.getLineHeight()){
            display.scrollTo(0, offset-display.getHeight());
        }
        display2.setText(String.format("%s%s%s", number, temp2, temp));
        display3.setText(String.format("number:%s", number));
        display4.setText(String.format("temp:%s", temp));
        display5.setText(String.format("show_temp:%s[temp2:%s]", show_temp, temp2));
        display6.setText(String.format("show:%s", showNumber));
    }
    public String del_shownumber(String str) {
        if(!str.equals("")){
            str = str.substring(0, str.length() - 1);
            return str;
        }
        return str;
    }
    public String del_number(String str) {
        if(!str.equals("")){
            switch (str.substring(str.length()-1)){
                case "n":
                    str = str.substring(0, str.length() - 2);
                    /*if(str.length() == 0){
                        break;
                    }*/
                    if(str.length()!=0){
                        if (!str.substring((str.length() - 1)).equals("o")) {
                            str += "n";
                        }
                    }

                    break;
                case "_":
                case "-":
                case "o":
                    str = str.substring(0, str.length() - 2);
                    break;
                case "(":
                    bs_counter -= 1;

                case ")":
                    str = str.substring(0, str.length() - 1);
                    break;
                case ".":
                    str = str.substring(0, str.length() - 1);
                    str += "n";
                    break;
            }
            return str;
        }
        return "";
    }
    public void temp_to_number() {
        if (!temp.equals("#")) {
            number += temp2;temp2 = "";
            number += temp;temp = "";
            showNumber += show_temp;show_temp = "";
        }
    }
    public void init_var(){
        showNumber = "";
        show_temp = "";
        number = "";
        show_temp = "";
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
        clean.setOnLongClickListener(this);
        display.setMovementMethod(ScrollingMovementMethod.getInstance());
    }


}
