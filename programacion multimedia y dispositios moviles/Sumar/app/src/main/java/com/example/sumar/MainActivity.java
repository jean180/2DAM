package com.example.sumar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        final TextView introduccion =(TextView) findViewById(R.id.introduccion);
        final EditText numero1 = (EditText) findViewById(R.id.numero1);
        final EditText numero2 = (EditText) findViewById(R.id.numero2);
        final Button calcular = (Button) findViewById(R.id.miBtn);
        final TextView resultado = (TextView) findViewById(R.id.resultado);



        numero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1.setText("");
            }
        });

        numero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero2.setText("");
            }
        });


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, PantallaResultado.class);
                Bundle miBundle = new Bundle();
                int num1, num2;
                if (numero1.getText().toString().equals("")){
                    num1 = 0;
                } else {
                    num1 = Integer.valueOf(numero1.getText().toString());
                }
                if (numero2.getText().toString().equals("")){
                    num2 = 0;
                } else {
                    num2 = Integer.valueOf(numero2.getText().toString());
                }
                String result = String.valueOf(num1+num2);
                miBundle.putString("TEXTO", result);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
    }
}