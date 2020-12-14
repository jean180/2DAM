package com.example.crm_leads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LeadsActivity extends AppCompatActivity {
    /**
     * Lo primero que he hecho es crear una actividad que sería LeadsActivity
     * la cual su proposito es actuar como punto de entrada
     * y en la cual añadiremos el fragmento.
     * Luego hemos creado el fragmento y hemos añadido un ListView al layout
     * Ahora creamos un adaptador que sera el que viene de base, el cual relacionaremos
     * con la ListView y así poblarla con una fuente de datos
     * posteriormente a esto implementamos ArrayAdapter en la cual cargarremos un array de Strings
     * con los nombre de ejemplo que más tarde cambiaremos por más datos
     * creamos el objeto que usaremos para los empleados
     * ahora creamos un layout dedicado para que los elemento de la lista se vean
     * esteticos y ordenados
     * Ahora creamos nuestro adaptador personalizado
     * utilizaremos la librería Glide por lo cual tendremos que importarla en el build.gradle
     * A continuación creamos un repositorio de datos en el cual almacenaremos además de los nombre, más datos
     * Ahora habilitamos el Action Bar en el cual añadiremos un boton para eliminar los datos de la lista
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LeadsFragment leadsFragment = (LeadsFragment) getSupportFragmentManager().findFragmentById(R.id.leads_container);

        if (leadsFragment == null) {
            leadsFragment = LeadsFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.leads_container, leadsFragment).commit();
        }
    }


}