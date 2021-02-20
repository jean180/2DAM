package org.instituserpis.ed.matriculas.Asignatura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.instituserpis.ed.matriculas.R;
import org.instituserpis.ed.matriculas.data.Alumno.AlumnoInsert;
import org.instituserpis.ed.matriculas.data.Asignatura.AsignaturaInsert;

public class Asignaturas extends AppCompatActivity implements DialogoAsignatura.OnSimpleDialogListener{

    private AsignaturaViewModel mViewModel;
    private RecyclerView mList;
    private AsignaturaAdapter mAdapter;
    private String icon_identity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        getSupportActionBar().setTitle("Asignaturas");

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        mViewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        setupList();

        setupFab();
    }

    //Añadir alumnos
    private void setupList() {
        mList = findViewById(R.id.list_asignaturas);
        mAdapter = new AsignaturaAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AsignaturaAdapter.ItemListener(){

            @Override
            public void onEditIconClicked(AsignaturaForList Asignatura){
                icon_identity = "edit";
                DialogoAsignatura d = new DialogoAsignatura(Asignatura);
                d.show(getSupportFragmentManager(), "DialogosAsignatura");
            }

            @Override
            public void onDeleteIconClicked(AsignaturaForList Asignatura) {
                int id = Asignatura.id;
                mViewModel.deleteAsignatura(Asignatura);
                Toast.makeText(getApplication(), "Eliminado " +id, Toast.LENGTH_SHORT).show();
            }
        });

        //Observar cambios
        mViewModel.getAllAsignaturas().observe(this, mAdapter::setItems);
    }

    //Listener para boton
    private void setupFab(){
        findViewById(R.id.floating_action_button_asignaturas)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        icon_identity = "add";
                        Asignatura_dialog();
                    }
                });
    }

    //Obtener instancia del dialog
    private void Asignatura_dialog(){
        new DialogoAsignatura().show(getSupportFragmentManager(), "DialogoAsignatura");
    }

    //Click guardar
    @Override
    public void onPossitiveButtonClick(String nombre_asignatura, int id, int num_estudiantes) {

        //Si hay 0 caracteres
        if (nombre_asignatura.isEmpty()) {
            return;
        }

        //si hemos pulsado añadir
        if (icon_identity.equals("add")) {
            AsignaturaInsert a = new AsignaturaInsert(nombre_asignatura);
            mViewModel.insert(a);
            Toast.makeText(this, "Añadido " + nombre_asignatura, Toast.LENGTH_SHORT).show();
        }

        //Si hemos pulsado edit
        if (icon_identity.equals("edit")) {

            AsignaturaForList a = new AsignaturaForList();
            a.nombre = nombre_asignatura;
            a.id = id;
            a.num_estudiantes = num_estudiantes;
            mViewModel.updateAsignatura(a);
            Toast.makeText(this, "Actualizado " + a.id, Toast.LENGTH_SHORT).show();
        }
    }

}