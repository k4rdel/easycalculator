package com.example.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;
    private Button buttonAdd;
    private Button buttonSubtract;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonPercent;
    private Button buttonPower;
    private Button buttonSqrt;
    private Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonPower = findViewById(R.id.buttonPower);
        buttonSqrt = findViewById(R.id.buttonSqrt);
        buttonClear = findViewById(R.id.buttonClear);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('%');
            }
        });

        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('^');
            }
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('√');
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void calculate(char operator) {
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();

        if (!num1Str.isEmpty()) {
            double num1 = Double.parseDouble(num1Str);
            double result = 0;

            switch (operator) {
                case '+':
                    if (!num2Str.isEmpty()) {
                        double num2 = Double.parseDouble(num2Str);
                        result = num1 + num2;
                    }
                    break;
                case '-':
                    if (!num2Str.isEmpty()) {
                        double num2 = Double.parseDouble(num2Str);
                        result = num1 - num2;
                    }
                    break;
                case '*':
                    if (!num2Str.isEmpty()) {
                        double num2 = Double.parseDouble(num2Str);
                        result = num1 * num2;
                    }
                    break;
                case '/':
                    if (!num2Str.isEmpty()) {
                        double num2 = Double.parseDouble(num2Str);
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textViewResult.setText("Cannot divide by zero");
                            return;
                        }
                    }
                    break;
                case '%':
                    if (!num2Str.isEmpty()) {
                        double num2 = Double.parseDouble(num2Str);
                        result = (num1 * num2) / 100;
                    }
                    break;
                case '^':
                    if (!num2Str.isEmpty()) {
                        double num2 = Double.parseDouble(num2Str);
                        result = Math.pow(num1, num2);
                    }
                    break;
                case '√':
                    result = Math.sqrt(num1);
                    break;
            }
            textViewResult.setText(String.valueOf(result));
        } else {
            textViewResult.setText("Please enter numbers");
        }
    }

    private void clearFields() {
        editTextNumber1.setText("");
        editTextNumber2.setText("");
        textViewResult.setText("Result");
    }
}