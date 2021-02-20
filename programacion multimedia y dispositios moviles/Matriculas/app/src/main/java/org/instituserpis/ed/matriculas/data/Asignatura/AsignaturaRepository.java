package org.instituserpis.ed.matriculas.data.Asignatura;

import android.content.Context;

import androidx.lifecycle.LiveData;

import org.instituserpis.ed.matriculas.Asignatura.AsignaturaForList;
import org.instituserpis.ed.matriculas.Asignatura.AsignaturaId;
import org.instituserpis.ed.matriculas.data.MatriculaDatabase;

import java.util.List;

public class AsignaturaRepository {

    //Variables
    private final LiveData<List<AsignaturaForList>> AsignaturaLists;
    private final AsignaturaDao asignaturaDao;

    //Constructor con parametros
    public AsignaturaRepository(Context context) {
        MatriculaDatabase db = MatriculaDatabase.getInstance(context);
        asignaturaDao = db.AsignaturaDao();
        AsignaturaLists = asignaturaDao.getAll();
    }

    //Obtener lista de asignaturas de db
    public LiveData<List<AsignaturaForList>> getAllAsignaturas() {
        return AsignaturaLists;
    }

    //Insertar asignatura a db
    public void insert(AsignaturaInsert asignatura) {
        MatriculaDatabase.dbExecutor.execute(
                () -> asignaturaDao.insert(asignatura)
        );
    }

    //actualizar asignatura
    public void updateAsignatura(AsignaturaForList Asignatura) {
        MatriculaDatabase.dbExecutor.execute(
                () -> asignaturaDao.updateAsignatura(Asignatura)
        );
    }

    //eliminar asignatura
    public void deleteAsignatura(AsignaturaId id) {
        MatriculaDatabase.dbExecutor.execute(
                () -> asignaturaDao.deleteAsignatura(id)
        );
    }


}
