package com.example.holamundo1;

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

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        final TextView elSaludo = (TextView) findViewById(R.id.MiLb);

        miTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elSaludo.setText("");
            }
        });

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensajeSaludo= "Te saludo " + miTexto.getText();
                elSaludo.setText(mensajeSaludo.toUpperCase());
            }
        });
    }
}