package org.instituserpis.ed.matriculas.Asignatura;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.instituserpis.ed.matriculas.data.Asignatura.AsignaturaInsert;
import org.instituserpis.ed.matriculas.data.Asignatura.AsignaturaRepository;

import java.util.List;

public class AsignaturaViewModel extends AndroidViewModel {

    //Variables
    private final AsignaturaRepository mRepository;
    private final LiveData<List<AsignaturaForList>> asignaturas;

    //Constructor con parametros
    public AsignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AsignaturaRepository(application);
        asignaturas = mRepository.getAllAsignaturas();
    }

    //Obtener lista asignaturas
    public LiveData<List<AsignaturaForList>> getAllAsignaturas() {
        return asignaturas;
    }

    //Insertar asignatura llamando al Repository
    public void insert(AsignaturaInsert asignatura) {
        mRepository.insert(asignatura);
    }

    //Actualizar asignatura
    public void updateAsignatura(AsignaturaForList Asignatura) {
        mRepository.updateAsignatura(Asignatura);
    }

    //Elñiminar asignatura
    public void deleteAsignatura(AsignaturaForList Asignatura) {
        AsignaturaId id = new AsignaturaId(Asignatura.id);
        mRepository.deleteAsignatura(id);
    }
}
