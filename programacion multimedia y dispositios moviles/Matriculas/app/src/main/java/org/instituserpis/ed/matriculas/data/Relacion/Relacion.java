package org.instituserpis.ed.matriculas.data.Relacion;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "relacion", primaryKeys = {"DNI", "Id_Asignatura"})
public class Relacion {

    @NonNull
    @ColumnInfo(name = "DNI")
    private String DNI;

    @NonNull
    @ColumnInfo(name = "Id_Asignatura")
    private int Id_Asignatura;

    @NonNull
    public String getDNI() {
        return DNI;
    }

    public int getId_Asignatura() {
        return Id_Asignatura;
    }
}
