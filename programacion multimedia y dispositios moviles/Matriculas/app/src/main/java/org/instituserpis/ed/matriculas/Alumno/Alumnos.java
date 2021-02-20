package org.instituserpis.ed.matriculas.Alumno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.instituserpis.ed.matriculas.R;
import org.instituserpis.ed.matriculas.data.Alumno.AlumnoInsert;

public class Alumnos extends AppCompatActivity implements DialogoAlumno.OnSimpleDialogListener{

    private AlumnoViewModel mViewModel;
    private RecyclerView mList;
    private AlumnoAdapter mAdapter;
    private String icon_identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        getSupportActionBar().setTitle("Alumnos");
        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AlumnoViewModel.class);

        setupList();

        setupFab();
    }

    //Añadir lista alumnos

    private void setupList() {
        mList = findViewById(R.id.list_alumnos);
        mAdapter = new AlumnoAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AlumnoAdapter.ItemListener() {
            @Override
            public void onEditIconClicked(AlumnoForList Alumno) {
                icon_identity = "edit";
                DialogoAlumno d = new DialogoAlumno(Alumno);
                d.show(getSupportFragmentManager(), "DialogoAlumno");
            }

            @Override
            public void onDeleteIconClicked(AlumnoForList Alumno) {
                String DNI = Alumno.DNI;
                mViewModel.deleteAlumno(Alumno);
                Toast.makeText(getApplication(), "Eliminado " + DNI, Toast.LENGTH_SHORT).show();
            }
        });

        //Observar cambios
        mViewModel.getAllAlumnos().observe(this,mAdapter::setItems);
    }

    //Listener de boton
    private void setupFab() {
        findViewById(R.id.floating_action_button_alumnos)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        icon_identity = "add";
                        Alumno_dialog();
                    }
                });
    }

    //Obtener dialogo
    private void Alumno_dialog(){
        new DialogoAlumno().show(getSupportFragmentManager(), "DialogoAlumnos");
    }

    //Guardar
    @Override
    public void onPossitiveButtonClick(String DNI, String nombre, String apellidos) {

        //Si hay 0 caracteres
        if (nombre.isEmpty() || DNI.isEmpty() || apellidos.isEmpty()) {
            return;
        }

        //Si hemos pulsado añador
        if (icon_identity.equals("add")) {
            AlumnoInsert a = new AlumnoInsert(DNI,nombre,apellidos);
            mViewModel.insert(a);
            Toast.makeText(this, "Añadido " + DNI,Toast.LENGTH_SHORT).show();
        }

        //Si hemos pulsado edit
        if (icon_identity.equals("edit")){
            AlumnoForList a = new AlumnoForList();
            a.DNI = DNI;
            a.nombre = nombre;
            a.apellidos = apellidos;
            mViewModel.updateAlumno(a);
            Toast.makeText(this, "Actualizado " + DNI, Toast.LENGTH_SHORT).show();
        }
    }
}