package com.example.projekat.DAO

import androidx.room.*
import com.example.projekat.entity.Kategorije
import com.example.projekat.entity.TipoviAktivnosti

@Dao
interface KategorijeDao {

    //suspend - da ne ometa glavu radnju prilikom izvšavanja
    //IGNORE - prije inserta pretrazi se tabela i ako ima kolona s aistim podacima ignorise unos
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(kategorije: Kategorije)

    //REPLACE - prije inserta pretrazi se tabela i ako ima kolona s aistim podacima (npr. id isti) zamijeni se
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(kategorije: Kategorije)

    @Query("SELECT * FROM kategorije")
    suspend fun getAll() : List<Kategorije>

    @Query("DELETE FROM kategorije")
    suspend fun deleteAll()

    @Query("DELETE FROM kategorije WHERE id = :id_K")
    suspend fun deleteId(id_K : Int)

    @Update
    suspend fun update(kategorije: Kategorije?)

    @Query("SELECT id FROM kategorije ORDER BY id DESC LIMIT 1")
    suspend fun getLastId() : Int
}