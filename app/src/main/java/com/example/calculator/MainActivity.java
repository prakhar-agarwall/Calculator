package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button no0;
    Button no1;
    Button no2;
    Button no3;
    Button no4;
    Button no5;
    Button no6;
    Button no7;
    Button no8;
    Button no9;
    Button dot;
    Button back;
    Button equal;
    Button clear;
    Button modulus;
    Button division;
    Button multiply;
    Button addition;
    Button subtraction;
    TextView resultTextView;

    double firstNumber=0,secondNumber=0;
    int secondNumberIndex=0;
    boolean status=false;
    char operator;
    int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupID();

        View.OnClickListener calculator = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();

                switch(id){
                    case R.id.no0:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("0");
                            break;
                        }
                        else {
                            resultTextView.append("0");
                            break;
                        }
                    case R.id.no1:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("1");
                            flag=0;
                            break;
                        }
                        else {
                            resultTextView.append("1");
                            break;
                        }
                    case R.id.no2:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("2");
                            flag=0;
                            break;
                        }
                        else {
                            resultTextView.append("2");
                            break;
                        }
                    case R.id.no3:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("3");
                            flag=0;
                            break;
                        }
                        else {
                            resultTextView.append("3");
                            break;
                        }
                    case R.id.no4:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("4");
                            flag=0;
                            break;
                    }
                    else {
                        resultTextView.append("4");
                        break;
                    }
                    case R.id.no5:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("5");
                            flag=0;
                            break;
                    }
                    else {
                        resultTextView.append("5");
                        break;
                    }
                    case R.id.no6:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("6");
                            flag=0;
                            break;
                    }
                    else {
                        resultTextView.append("6");
                        break;
                    }
                    case R.id.no7:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("7");
                            flag=0;
                            break;
                    }
                    else {
                        resultTextView.append("7");
                        break;
                    }
                    case R.id.no8:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("8");
                            flag=0;
                            break;
                        }
                        else {
                            resultTextView.append("8");
                            break;
                        }
                    case R.id.no9:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append("9");
                            flag=0;
                            break;
                        }
                        else {
                            resultTextView.append("9");
                            break;
                        }
                    case R.id.dot:
                        if(flag == 1){
                            resultTextView.setText("");
                            resultTextView.append(".");
                            flag=0;
                            break;
                        }
                        else {
                            resultTextView.append(".");
                            break;
                        }
                    case R.id.addition:
                        status = true;
                        operator = '+';
                        String displayed1 = resultTextView.getText().toString();
                        firstNumber = Double.parseDouble(displayed1);
                        resultTextView.append("+");
                        secondNumberIndex = displayed1.length() + 1;
                        break;
                    case R.id.subtraction:
                        status = true;
                        operator = '-';
                        String displayed2 = resultTextView.getText().toString();
                        firstNumber = Double.parseDouble(displayed2);
                        resultTextView.append("-");
                        secondNumberIndex = displayed2.length() + 1;
                        break;
                    case R.id.multiply:
                        status = true;
                        operator = '*';
                        String displayed3 = resultTextView.getText().toString();
                        firstNumber = Double.parseDouble(displayed3);
                        resultTextView.append("*");
                        secondNumberIndex = displayed3.length() + 1;
                        break;
                    case R.id.division:
                        status = true;
                        operator = '÷';
                        String displayed4 = resultTextView.getText().toString();
                        firstNumber = Double.parseDouble(displayed4);
                        resultTextView.append("÷");
                        secondNumberIndex = displayed4.length() + 1;
                        break;
                    case R.id.modulo:
                        status = true;
                        operator = '%';
                        String displayed5 = resultTextView.getText().toString();
                        firstNumber = Double.parseDouble(displayed5);
                        resultTextView.append("%");
                        secondNumberIndex = displayed5.length() + 1;
                        break;
                    case R.id.clear:
                        resultTextView.setText("");
                        initialize();
                        break;
                    case R.id.back:
                        String displayedInfo = resultTextView.getText().toString();
                        int length = displayedInfo.length();
                        if(length>1){
                            displayedInfo = displayedInfo.substring(0,length-1);
                            resultTextView.setText(displayedInfo);
                        }
                        else{
                            return;
                        }
                    case R.id.equal:

                        String displayedContent = resultTextView.getText().toString();
                        int size = displayedContent.length();
                        secondNumber = Double.parseDouble(displayedContent.substring(secondNumberIndex,size));

                        if(status) {
                            flag = 1;
                            if(operator == '+'){
                                firstNumber += secondNumber;
                                resultTextView.setText(String.valueOf(firstNumber));
                                Toast.makeText(MainActivity.this, String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
                                initialize();
                            }
                            else if(operator == '-'){
                                firstNumber -= secondNumber;
                                resultTextView.setText(String.valueOf(firstNumber));
                                Toast.makeText(MainActivity.this, String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
                                initialize();
                            }
                            else if(operator == '*'){
                                firstNumber *= secondNumber;
                                resultTextView.setText(String.valueOf(firstNumber));
                                Toast.makeText(MainActivity.this, String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
                                initialize();
                            }
                            else if(operator == '÷'){
                                firstNumber /= secondNumber;
                                resultTextView.setText(String.valueOf(firstNumber));
                                Toast.makeText(MainActivity.this, String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
                                initialize();
                            }
                            else if(operator == '%'){
                                firstNumber %= secondNumber;
                                resultTextView.setText(String.valueOf(firstNumber));
                                Toast.makeText(MainActivity.this, String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
                                initialize();
                            }
                        }
                        else{
                            return;
                    }



                }
            }
        };

        no0.setOnClickListener(calculator);
        no1.setOnClickListener(calculator);
        no2.setOnClickListener(calculator);
        no3.setOnClickListener(calculator);
        no4.setOnClickListener(calculator);
        no5.setOnClickListener(calculator);
        no6.setOnClickListener(calculator);
        no7.setOnClickListener(calculator);
        no8.setOnClickListener(calculator);
        no9.setOnClickListener(calculator);
        dot.setOnClickListener(calculator);
        back.setOnClickListener(calculator);
        equal.setOnClickListener(calculator);
        clear.setOnClickListener(calculator);
        modulus.setOnClickListener(calculator);
        addition.setOnClickListener(calculator);
        multiply.setOnClickListener(calculator);
        division.setOnClickListener(calculator);
        subtraction.setOnClickListener(calculator);


    }

    private void setupID(){

        no0 = (Button) findViewById(R.id.no0);
        no1 = (Button) findViewById(R.id.no1);
        no2 = (Button) findViewById(R.id.no2);
        no3 = (Button) findViewById(R.id.no3);
        no4 = (Button) findViewById(R.id.no4);
        no5 = (Button) findViewById(R.id.no5);
        no6 = (Button) findViewById(R.id.no6);
        no7 = (Button) findViewById(R.id.no7);
        no8 = (Button) findViewById(R.id.no8);
        no9 = (Button) findViewById(R.id.no9);
        dot = (Button) findViewById(R.id.dot);
        back = (Button) findViewById(R.id.back);
        equal = (Button) findViewById(R.id.equal);
        clear = (Button) findViewById(R.id.clear);
        modulus = (Button) findViewById(R.id.modulo);
        division = (Button) findViewById(R.id.division);
        multiply = (Button) findViewById(R.id.multiply);
        addition = (Button) findViewById(R.id.addition);
        subtraction = (Button) findViewById(R.id.subtraction);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

    }

    private void initialize(){
        firstNumber = 0;
        secondNumber = 0;
        secondNumberIndex = 0;
        status = false;
        operator = ' ';
        //flag = 0;
        //resultTextView.setText("");
    }

}
