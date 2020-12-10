package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button add_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        //Obteniendo la instancia del botón add_fragment
        add_fragment = (Button)findViewById(R.id.add_fragment);

        //Seteando la escucha del botón
        add_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Paso 1: Obtener la instancia de administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager();

                //Paso2: Crear una nueva transacción
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //Paso 3: Crear un nuevo fragmento y añadirlo
                CountFragment fragment = new CountFragment();
                transaction.add(R.id.contenedor);
                //Paso 4: confirmar los cambios
                transaction.commit();
            }
        });

    }
}