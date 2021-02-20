package org.instituserpis.ed.matriculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.instituserpis.ed.matriculas.Alumno.Alumnos;
import org.instituserpis.ed.matriculas.Asignatura.Asignaturas;
import org.instituserpis.ed.matriculas.data.Alumno.Alumno;

public class MainActivity extends AppCompatActivity {

    private Button btn_asignaturas, btn_alumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Identificamos cada boton por su ID
        btn_asignaturas = (Button) findViewById(R.id.btn_asignaturas);
        btn_alumnos = (Button) findViewById(R.id.btn_alumnos);

        btn_asignaturas.setOnClickListener(new listener_btn());
        btn_alumnos.setOnClickListener(new listener_btn());

    }

    //listener de los botones
    class listener_btn implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.equals(btn_asignaturas)){

                Intent intent = new Intent(MainActivity.this, Asignaturas.class);
                startActivity(intent);
            } else if (view.equals(btn_alumnos)){
                Intent intent = new Intent(MainActivity.this, Alumnos.class);
                startActivity(intent);
            }
        }
    }
}