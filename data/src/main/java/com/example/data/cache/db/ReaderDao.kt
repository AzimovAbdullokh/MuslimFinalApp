package com.example.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.cache.models.ReadersCache
import kotlinx.coroutines.flow.Flow

@Dao
interface ReaderDao {

    @Query("select * from READERS_TABLE")
    fun fetchAllReadersObservable(): Flow<MutableList<ReadersCache>>

    @Query("select * from READERS_TABLE")
    suspend fun fetchAllReadersSingle(): MutableList<ReadersCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewReaders(reader: ReadersCache)

    @Query("select * from READERS_TABLE where id == :readerId")
    suspend fun fetchReadersFromId(readerId: String): ReadersCache

    @Query("DELETE FROM READERS_TABLE")
    fun clearTable()
}