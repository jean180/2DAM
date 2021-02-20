package org.instituserpis.ed.matriculas.data.Asignatura;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.instituserpis.ed.matriculas.Asignatura.AsignaturaForList;
import org.instituserpis.ed.matriculas.Asignatura.AsignaturaId;

import java.util.List;

@Dao
public interface AsignaturaDao {

    // listar todas las asignaturas
    @Query("SELECT * FROM asignatura")
    LiveData<List<AsignaturaForList>> getAll();

    //insertar asignatura
    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Asignatura.class)
    void insert(AsignaturaInsert Asignatura);

    //Insertar varias asignaturas
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAsignaturas(List<Asignatura> asignaturas);

    //Eliminar asignaturas
    @Delete(entity = Asignatura.class)
    void deleteAsignatura(AsignaturaId id);

    //Actualizar asignatura
    @Update(entity = Asignatura.class)
    void updateAsignatura(AsignaturaForList Asignatura);
}
