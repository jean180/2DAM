package org.instituserpis.ed.matriculas.data.Alumno;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.instituserpis.ed.matriculas.Alumno.AlumnoDNI;
import org.instituserpis.ed.matriculas.Alumno.AlumnoForList;

import java.util.List;

@Dao
public interface AlumnoDao {

    // listar todos los alumnos
    @Query("SELECT * FROM alumno")
    LiveData<List<AlumnoForList>> getAll();

    //Insertar alumno
    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Alumno.class)
    void insert(AlumnoInsert Alumno);

    //eliminar alumno
    @Delete(entity = Alumno.class)
    void deleteAlumno(AlumnoDNI id);

    //Actualizar alumno
    @Update(entity = Alumno.class)
    void updateAlumno(AlumnoForList Alumno);
}
