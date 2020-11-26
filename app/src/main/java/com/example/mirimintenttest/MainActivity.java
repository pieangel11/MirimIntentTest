package com.example.mirimintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnResult = findViewById(R.id.btn_result);
        rg = findViewById(R.id.rg);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        btnResult.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("input1", edit1.getText().toString());
            intent.putExtra("input2", edit2.getText().toString());

            String op = "";

            switch (rg.getCheckedRadioButtonId()){
                case R.id.radio_plus:
                    op = "+";
                    break;
                case R.id.radio_minus:
                    op = "-";
                    break;
                case R.id.radio_multi:
                    op = "*";
                    break;
                case R.id.radio_divide:
                    op = "/";
                    break;
            }

            intent.putExtra("op", op);
            startActivity(intent);
        }
    };
}