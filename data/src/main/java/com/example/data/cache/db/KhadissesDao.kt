package com.example.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.cache.models.KhadissesCache
import kotlinx.coroutines.flow.Flow

@Dao
interface KhadissesDao {

    @Query("select * from KHADISSES_TABLE")
    fun fetchAllKhadissesObservable(): Flow<MutableList<KhadissesCache>>

    @Query("select * from KHADISSES_TABLE")
    suspend fun fetchAllKhadissesSingle(): MutableList<KhadissesCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewKhadis(khadis: KhadissesCache)

    @Query("select * from KHADISSES_TABLE where id == :khadisId")
    suspend fun fetchKhadissesFromId(khadisId: String): KhadissesCache

    @Query("DELETE FROM KHADISSES_TABLE")
    fun clearTable()
}