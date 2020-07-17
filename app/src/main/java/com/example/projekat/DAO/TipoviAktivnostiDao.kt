package com.example.projekat.DAO

import androidx.room.*
import com.example.projekat.entity.TipoviAktivnosti

@Dao
interface TipoviAktivnostiDao {

    //suspend - da ne ometa glavu radnju prilikom izvšavanja
    //IGNORE - prije inserta pretrazi se tabela i ako ima kolona s aistim podacima ignorise unos
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tipoviAktivnosti: TipoviAktivnosti)

    //REPLACE - prije inserta pretrazi se tabela i ako ima kolona s aistim podacima (npr. id isti) zamijeni se
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(tipoviAktivnosti: TipoviAktivnosti)

    @Query("SELECT * FROM tipoviAktivnosti")
    suspend fun getAll() : List<TipoviAktivnosti>

    @Query("DELETE FROM tipoviAktivnosti")
    suspend fun deleteAll()

    @Query("DELETE FROM tipoviAktivnosti WHERE id = :id_TA")
    suspend fun deleteId(id_TA : Int)

    @Update
    suspend fun update(tipoviAktivnosti: TipoviAktivnosti?)

    @Query("SELECT id FROM tipoviAktivnosti ORDER BY id DESC LIMIT 1")
    suspend fun getLastId() : Int
}