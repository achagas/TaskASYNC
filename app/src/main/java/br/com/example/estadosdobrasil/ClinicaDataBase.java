package br.com.example.estadosdobrasil;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.example.estadosdobrasil.Dao.ClinicaDao;
import br.com.example.estadosdobrasil.Model.Clinica;

@Database(entities = {Clinica.class}, version = 1)
public abstract class ClinicaDataBase extends RoomDatabase {

    private static final String TAG = "ClinicaDataBase";
    private static final String DB_NAME = "Clinica.db";
    private static volatile ClinicaDataBase instance;

    public static ClinicaDataBase getInstance(Context context){
        if(instance== null) {
            instance = create(context);
        }
        return instance;
    }

    private static ClinicaDataBase create(Context context){
        return Room.databaseBuilder(context, ClinicaDataBase.class, DB_NAME).build();
    }
    public abstract ClinicaDao getDao();
}
