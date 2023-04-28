package com.example.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.cache.models.SurahCache
import kotlinx.coroutines.flow.Flow

@Dao
interface SurahDao {

    @Query("select * from SURAH_TABLE")
    fun fetchAllSurahObservable(): Flow<MutableList<SurahCache>>

    @Query("select * from SURAH_TABLE")
    suspend fun fetchAllSurahSingle(): MutableList<SurahCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewSurah(surah: SurahCache)

    @Query("select * from SURAH_TABLE where id == :surahId")
    fun fetchSurahObservable(surahId: String): Flow<SurahCache?>

    @Query("select * from SURAH_TABLE where id == :surahId")
    suspend fun fetchSurahFromId(surahId: String): SurahCache

    @Query("DELETE FROM SURAH_TABLE")
    fun clearTable()
}