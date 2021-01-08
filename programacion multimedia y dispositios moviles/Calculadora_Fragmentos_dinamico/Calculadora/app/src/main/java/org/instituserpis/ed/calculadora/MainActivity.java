package org.instituserpis.ed.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button BtnMostrar = (Button) findViewById(R.id.BtnMostrar);

        BtnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                BlankFragment fragment = new BlankFragment();
                transaction.add(R.id.contenedor, fragment);
                transaction.commit();
                Toast.makeText(MainActivity.this, "Fragmento añadido", Toast.LENGTH_SHORT).show();
            }
        });

    }

}