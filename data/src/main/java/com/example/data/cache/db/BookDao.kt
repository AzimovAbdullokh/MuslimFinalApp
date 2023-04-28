package com.example.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.cache.models.BookCache
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("select * from book_table")
    fun fetchAllBooksObservable(): Flow<MutableList<BookCache>>

    @Query("select * from book_table")
    suspend fun fetchAllBooksSingle(): MutableList<BookCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewBook(books: BookCache)

    @Query("select * from book_table where id == :bookId")
    fun fetchBookObservable(bookId: String): Flow<BookCache?>

    @Query("select * from book_table where id == :bookId")
    suspend fun fetchBooksFromId(bookId: String): BookCache

    @Query("DELETE FROM book_table")
    fun clearTable()

}