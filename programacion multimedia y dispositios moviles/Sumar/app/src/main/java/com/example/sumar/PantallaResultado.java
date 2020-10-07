package com.example.sumar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultado);
        final TextView Resultado = (TextView)findViewById(R.id.resultado);
        Bundle miBundleRecoger = getIntent().getExtras();
        Resultado.setText(miBundleRecoger.getString("TEXTO"));
        final Button miBotonVolver = (Button) findViewById(R.id.botonVolver);
        miBotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(PantallaResultado.this, MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}