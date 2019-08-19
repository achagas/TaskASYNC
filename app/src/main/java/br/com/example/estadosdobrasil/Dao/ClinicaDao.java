package br.com.example.estadosdobrasil.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.example.estadosdobrasil.Model.Clinica;

@Dao
public interface ClinicaDao {

    @Query("SELECT * FROM clinica")
    List<Clinica> getAllclinica();

    @Query("SELECT * FROM clinica WHERE uniq_id = :uniq_id")
    List<Clinica> getClinica(String uniq_id);

    @Insert
    void insert(Clinica... c);
    @Delete
    void update(Clinica... c);
    @Update
    void delete(Clinica... c);

}
