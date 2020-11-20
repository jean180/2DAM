package org.instituserpis.ed.perrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    public final static int OPTION_REQUEST_CODE = 1;
    public final static String EXTRA_NOMBRE = "org.instituserpis.ed.perrito.NOMBRE";

    private Button show_pet_button;
    private TextView page_link;
    private TextView opinion_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtener instancia del boton
        show_pet_button = (Button)findViewById(R.id.show_pet_button);

        page_link = (TextView)findViewById(R.id.autores);

        opinion_text = (TextView) findViewById(R.id.opinion_text);

        //listener del boton
        show_pet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent actividad visor
                Intent intent = new Intent(MainActivity.this, Visor.class);

                //Adhesión cadena
                intent.putExtra(EXTRA_NOMBRE, "pet1.jpg");

                //Inicio actividad esperando resultado
                startActivityForResult(intent, OPTION_REQUEST_CODE);
            }
        });

        page_link.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Uri webpage = Uri.parse("http://hermosaprogramacion.blogspot.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                //Verificar si hay aplicaciones disponibles
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(webIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                //Si hay
                if (isIntentSafe){
                    startActivity(webIntent);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == OPTION_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra("opinion");
                opinion_text.setText("Tu opinion fué " + result);
            }
        }
    }
}