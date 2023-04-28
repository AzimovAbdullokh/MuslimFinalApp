package com.example.data.cache.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.cache.models.CategoryCache
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("select * from CATEGORIES_TABLE")
    fun fetchAllCategoriesObservable(): Flow<MutableList<CategoryCache>>

    @Query("select * from CATEGORIES_TABLE")
    suspend fun fetchAllCategoriesSingle(): MutableList<CategoryCache>

    @Query("select * from CATEGORIES_TABLE where id == :categoryId")
    suspend fun fetchCategoryFromId(categoryId: String): CategoryCache

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewCategory(category: CategoryCache)

    @Query("DELETE FROM CATEGORIES_TABLE")
    fun clearTable()
}