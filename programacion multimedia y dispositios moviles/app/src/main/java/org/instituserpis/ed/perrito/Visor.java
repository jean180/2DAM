package org.instituserpis.ed.perrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Visor extends AppCompatActivity {

    private TextView image_name;
    private RadioGroup opiniones;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        //Obtener instancias de nuestros views
        image_name = (TextView)findViewById(R.id.image_name);
        opiniones = (RadioGroup)findViewById(R.id.opiniones_group);
        enviar = (Button)findViewById(R.id.send_button);

        //Obtener instancia de intent
        Intent intent = getIntent();

        //Extraer extra
        String name = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);

        //asignar valor del extra en el textview
        image_name.setText(name);

        //onclick de Enviar
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtener el radiobutton seleccionado
                RadioButton currentRadio = (RadioButton)findViewById(opiniones.getCheckedRadioButtonId());

                //Obtener la cadena del radiobutton
                String opinion = currentRadio.getText().toString();

                //Intent de respuesta
                Intent databack = new Intent();

                //añadir la ceadena a devolver
                databack.putExtra("opinion", opinion);

                //Devovler el intent de foram exitosa
                setResult(RESULT_OK,databack);

                //terminar actividad
                finish();
            }
        });

    }
}