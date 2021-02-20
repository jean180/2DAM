package org.instituserpis.ed.matriculas.Alumno;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.instituserpis.ed.matriculas.data.Alumno.AlumnoInsert;
import org.instituserpis.ed.matriculas.data.Alumno.AlumnoRepository;

import java.util.List;

public class AlumnoViewModel extends AndroidViewModel {

    //Variables
    private final AlumnoRepository mRepository;
    private final LiveData<List<AlumnoForList>> alumnos;

    //constructor
    public AlumnoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AlumnoRepository(application);
        alumnos = mRepository.getAllAlumnos();
    }

    //obtener lista alumnos
    public LiveData<List<AlumnoForList>> getAllAlumnos() {
        return alumnos;
    }

    //insertar alumno llamando al repositorio
    public void insert(AlumnoInsert alumno) {
        mRepository.insert(alumno);
    }

    //Actualizar alumno
    public void updateAlumno(AlumnoForList Alumno) {
        mRepository.updateAlumno(Alumno);
    }

    //Eliminar alumno
    public void deleteAlumno(AlumnoForList Alumno) {
        AlumnoDNI dni = new AlumnoDNI(Alumno.DNI);
        mRepository.deleteAlumno(dni);
    }
}
