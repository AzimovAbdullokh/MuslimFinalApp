package com.example.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.cache.models.AudioNasheedsCashe
import kotlinx.coroutines.flow.Flow


@Dao
interface AudioNasheedsDao {

    @Query("select * from AUDIO_NASHEEDS_TABLE")
    fun fetchAllAudioNasheedsObservable():Flow<MutableList<AudioNasheedsCashe>>

    @Query("select * from AUDIO_NASHEEDS_TABLE where id == :audioNasheedId")
    fun fetchAudioNasheedFromIdObservable(audioNasheedId: String): Flow<AudioNasheedsCashe?>

    @Query("select * from AUDIO_NASHEEDS_TABLE")
    suspend fun fetchAllAudioNasheedsSingle():MutableList<AudioNasheedsCashe>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewNasheed(audioNasheed: AudioNasheedsCashe)

    @Query("select * from AUDIO_NASHEEDS_TABLE where id == :audioNasheedId")
    suspend fun fetchAudioNasheedsFromId(audioNasheedId: String): AudioNasheedsCashe

    @Query("DELETE FROM AUDIO_NASHEEDS_TABLE")
    fun clearTable()
}