package com.example.holamundo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton miBoton=(ImageButton)findViewById(R.id.miBtn);
        final EditText miTexto = (EditText)findViewById(R.id.miTxt);
        final TextView elSaludo = (TextView)findViewById(R.id.miLbl);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);

                //Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
               // miBundle.putString("TEXTO", mensajePaso);
                // miIntent.putExtra(miBundle);
                startActivity(miIntent);
                showToast("Pulsando BOTON");
            }
        });
    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        //CharSequence text = getResources().getString(R.string.noNameMsg);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    @Override protected void onStart(){
        super.onStart();
        Toast.makeText(this, "A1:onStart", Toast.LENGTH_LONG).show();
    }
    @Override protected void onResume(){
        super.onResume();
        Toast.makeText(this, "A1:onResume", Toast.LENGTH_LONG).show();
    }
    @Override protected void onPause(){
        Toast.makeText(this, "A1:onPauset", Toast.LENGTH_LONG).show();
        super.onPause();
    }
    @Override protected void onStop(){
        super.onStop();
        Toast.makeText(this, "A1:onStart", Toast.LENGTH_LONG).show();
    }
    @Override protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "A1:onRestart", Toast.LENGTH_LONG).show();
    }
    @Override protected void onDestroy(){
        Toast.makeText(this, "A1:onDestroy", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

}