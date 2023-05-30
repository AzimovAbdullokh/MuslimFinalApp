package com.example.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.cache.models.NamesCache
import kotlinx.coroutines.flow.Flow
@Dao
interface NamesDao {

    @Query("select * from NAMES_TABLE")
    fun fetchAllNamesObservable(): Flow<MutableList<NamesCache>>

    @Query("select * from NAMES_TABLE")
    suspend fun fetchAllNamesSingle(): MutableList<NamesCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewName(name: NamesCache)


    @Query("DELETE FROM NAMES_TABLE")
    fun clearTable()
}