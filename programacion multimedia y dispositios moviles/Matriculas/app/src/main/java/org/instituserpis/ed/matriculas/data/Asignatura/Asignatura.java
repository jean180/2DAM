package org.instituserpis.ed.matriculas.data.Asignatura;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "asignatura")
public class Asignatura {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "nombre")
    private final String nombre;

    @NonNull
    @ColumnInfo(name = "num_estudiantes")
    private int num_estudiantes;

    public Asignatura(@NonNull String nombre){
        this.nombre = nombre;
        num_estudiantes = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNum_estudiantes() {
        return num_estudiantes;
    }

    public void setNum_estudiantes(int num_estudiantes) {
        this.num_estudiantes = num_estudiantes;
    }
}
