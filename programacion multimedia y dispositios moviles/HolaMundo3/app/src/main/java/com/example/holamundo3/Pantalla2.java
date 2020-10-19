package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Pantalla2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView)findViewById(R.id.miMensaje);
        final ImageButton imgBtn = (ImageButton)findViewById(R.id.imgVolver);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        final String completarSaludo = miBundleRecoger.getString("TEXTO");
        imgBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent = new Intent();
                Bundle vueltaBundle = new Bundle();
                String mensajeDevuelto = "Devuelvo a Principal " + completarSaludo;
                vueltaBundle.putString("DEVUELTO", mensajeDevuelto);
                vueltaIntent.putExtras(vueltaBundle);
                setResult(RESULT_OK, vueltaIntent);
                finish();
            }
        });
    }
}