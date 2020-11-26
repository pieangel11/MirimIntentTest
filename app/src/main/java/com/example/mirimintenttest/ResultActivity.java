package com.example.mirimintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textResult = findViewById(R.id.text_result);

        Intent intent = getIntent();
        int input1 = Integer.parseInt(intent.getStringExtra("input1"));
        int input2 = Integer.parseInt(intent.getStringExtra("input2"));

        String op = intent.getStringExtra("op");

        String result = "";

        switch (op){
            case "+":
                result = input1 + " + " + input2 + " = " + (input1+input2);
                break;
            case "-":
                result = input1 + " - " + input2 + " = " + (input1-input2);
                break;
            case "*":
                result = input1 + " * " + input2 + " = " + (input1*input2);
                break;
            case "/":
                result = input1 + " / " + input2 + " = " + (input1/input2);
                break;
        }

        textResult.setText(result);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}