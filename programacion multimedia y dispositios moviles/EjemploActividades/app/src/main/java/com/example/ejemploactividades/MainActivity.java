package com.example.ejemploactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText numero1 = (EditText) findViewById(R.id.num1);
        final EditText numero2 = (EditText) findViewById(R.id.num2);
        final TextView resultado = (TextView) findViewById(R.id.result);
        final Button bntSumar = (Button) findViewById(R.id.BtnSuma);

        bntSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1 = Integer.valueOf(numero1.getText().toString());
                int num2 = Integer.valueOf(numero2.getText().toString());
                if (numero1.getText().toString().equals("")) {
                    num1 = 0;
                } else {
                    num1 = Integer.valueOf(numero1.getText().toString());
                }
                if (numero2.getText().toString().equals("")) {
                    num2 = 0;
                } else {
                    num2 = Integer.valueOf(numero2.getText().toString());
                }
                String result = String.valueOf(num1 + num2);
                resultado.setText("= " + result);
            }
        });
    }
}