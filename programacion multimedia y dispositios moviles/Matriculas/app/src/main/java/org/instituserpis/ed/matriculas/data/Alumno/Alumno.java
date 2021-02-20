package org.instituserpis.ed.matriculas.data.Alumno;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "alumno")
public class Alumno {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "DNI")
    private final String DNI;

    @NonNull
    @ColumnInfo(name = "nombre")
    private final String nombre;

    @Nullable
    @ColumnInfo(name = "apellidos")
    private final String apellidos;

    public Alumno(@NonNull String DNI, @NonNull String nombre, @Nullable String apellidos) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @NonNull
    public String getDNI() {
        return DNI;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    @Nullable
    public String getApellidos() {
        return apellidos;
    }
}
