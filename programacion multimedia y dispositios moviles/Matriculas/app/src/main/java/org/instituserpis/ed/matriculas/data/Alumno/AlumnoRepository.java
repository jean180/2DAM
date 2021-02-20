package org.instituserpis.ed.matriculas.data.Alumno;

import android.content.Context;

import androidx.lifecycle.LiveData;

import org.instituserpis.ed.matriculas.Alumno.AlumnoDNI;
import org.instituserpis.ed.matriculas.Alumno.AlumnoForList;
import org.instituserpis.ed.matriculas.data.MatriculaDatabase;

import java.util.List;

public class AlumnoRepository {
    //Variables
    private final LiveData<List<AlumnoForList>> AlumnoLists;
    private final AlumnoDao alumnoDao;

    //constructor con parametros

    public AlumnoRepository(Context context) {
        MatriculaDatabase db = MatriculaDatabase.getInstance(context);
        alumnoDao = db.AlumnoDao();
        AlumnoLists = alumnoDao.getAll();
    }

    //obtener lista alumnos de db
    public LiveData<List<AlumnoForList>> getAllAlumnos() {
        return AlumnoLists;
    }

    //insertar alumno a db
    public void insert(AlumnoInsert alumno) {
        MatriculaDatabase.dbExecutor.execute(
                () -> alumnoDao.insert(alumno)
        );
    }

    //Actualizar alumno
    public void updateAlumno(AlumnoForList Alumno) {
        MatriculaDatabase.dbExecutor.execute(
                () -> alumnoDao.updateAlumno(Alumno)
        );
    }

    //Delete alumno
    public void deleteAlumno(AlumnoDNI dni){
        MatriculaDatabase.dbExecutor.execute(
                () -> alumnoDao.deleteAlumno(dni)
        );
    }
}
