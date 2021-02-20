package org.instituserpis.ed.matriculas.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.instituserpis.ed.matriculas.data.Alumno.Alumno;
import org.instituserpis.ed.matriculas.data.Alumno.AlumnoDao;
import org.instituserpis.ed.matriculas.data.Alumno.AlumnoInsert;
import org.instituserpis.ed.matriculas.data.Asignatura.Asignatura;
import org.instituserpis.ed.matriculas.data.Asignatura.AsignaturaDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        Alumno.class,
        Asignatura.class}, version = 1, exportSchema = false)
public abstract class MatriculaDatabase extends RoomDatabase {

    //Exposición de DAOs
    public abstract AlumnoDao AlumnoDao();
    public abstract AsignaturaDao AsignaturaDao();

    private static final String DATABASE_NAME = "Matricula-db";

    private static MatriculaDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static MatriculaDatabase getInstance(final Context context){

        if (INSTANCE == null) {
            synchronized (MatriculaDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), MatriculaDatabase.class,
                            DATABASE_NAME)
                            .addCallback(mRoomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    //Prepoblar base de datos con callback
    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() ->{
                //Variables
                AlumnoDao alumno_dao = INSTANCE.AlumnoDao();
                AsignaturaDao asignatura_dao = INSTANCE.AsignaturaDao();
                List<Asignatura> list_asignaturas = new ArrayList<>();

                //insert predefinido de alumnos
                AlumnoInsert a1 = new AlumnoInsert("26549831B", "Jean", "Ramos");
                AlumnoInsert a2 = new AlumnoInsert("12345678A", "Carlo", "Aguilar");
                alumno_dao.insert(a1);
                alumno_dao.insert(a2);

                //insert predefinido de asignaturas
                Asignatura as1 = new Asignatura("Acceso a datos");
                Asignatura as2 = new Asignatura("Programación de servicios y procesos");
                Asignatura as3 = new Asignatura("Sistemas de gestión empresarial");
                Asignatura as4 = new Asignatura("Desarrollo de interfaces");
                Asignatura as5 = new Asignatura("Programación multimedia y dispositivos móviles");

                list_asignaturas.add(as1);
                list_asignaturas.add(as2);
                list_asignaturas.add(as3);
                list_asignaturas.add(as4);
                list_asignaturas.add(as5);

                asignatura_dao.insertAsignaturas(list_asignaturas);
            });
        }
    };
}
