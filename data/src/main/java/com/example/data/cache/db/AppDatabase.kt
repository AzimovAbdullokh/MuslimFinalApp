package com.example.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.data.cache.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.lang.reflect.Type
import java.util.*

@Database(entities = [AudioNasheedsCashe::class, KhadissesCache::class, BookCache::class, CategoryCache::class, ReadersCache::class, SurahCache::class, QuestionsCache::class],

    version = 5, exportSchema = true)

@TypeConverters(AppDatabase.DatabaseConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNasheedsDao(): AudioNasheedsDao

    abstract fun getKhadissesDao(): KhadissesDao

    abstract fun getBooksDao(): BookDao

    abstract fun getCategoriesDao(): CategoryDao

    abstract fun getReadersDao(): ReaderDao

    abstract fun getSurahDao(): SurahDao

    abstract fun getQuestionsDao(): QuestionsDao

    class DatabaseConverter {

        @TypeConverter
        fun fromPosterNamaz(namazPosterCache: NamazPosterCache): String {
            return JSONObject().apply {
                put("namazPosterCache.name", namazPosterCache.name)
                put("namazPosterCache.url", namazPosterCache.url)
                put("namazPosterCache.type", namazPosterCache.type)
            }.toString()
        }

        @TypeConverter
        fun toPosterNamaz(source: String): NamazPosterCache {
            val json = JSONObject(source)
            return NamazPosterCache(
                name = json.getString("namazPosterCache.name"),
                url = json.getString("namazPosterCache.url"),
                type = json.getString("namazPosterCache.type"),
            )
        }

        @TypeConverter
        fun fromPdf(bookPdfCache: BookPdfCache): String {
            return JSONObject().apply {
                put("bookPdfCache.name", bookPdfCache.name)
                put("bookPdfCache.url", bookPdfCache.url)
                put("bookPdfCache.type", bookPdfCache.type)
            }.toString()
        }

        @TypeConverter
        fun toPdf(source: String): BookPdfCache {
            val json = JSONObject(source)
            return BookPdfCache(
                name = json.getString("bookPdfCache.name"),
                url = json.getString("bookPdfCache.url"),
                type = json.getString("bookPdfCache.type"),
            )
        }

        @TypeConverter
        fun fromPoster(bookPosterCache: BookPosterCache): String {
            return JSONObject().apply {
                put("bookPosterCache.name", bookPosterCache.name)
                put("bookPosterCache.url", bookPosterCache.url)
                put("bookPosterCache.type", bookPosterCache.type)
            }.toString()
        }

        @TypeConverter
        fun toPoster(source: String): BookPosterCache {
            val json = JSONObject(source)
            return BookPosterCache(name = json.getString("bookPosterCache.name"),
                url = json.getString("bookPosterCache.url"),
                type = json.getString("bookPosterCache.type"))
        }

        @TypeConverter
        fun toDate(dateLong: Long?): Date? {
            return dateLong?.let { Date(it) }
        }

        @TypeConverter
        fun fromDate(date: Date?): Long? {
            return date?.time
        }

        @TypeConverter
        fun fromAudioNasheedFile(audioNasheedFileCache: AudioNasheedFileCache): String {
            return JSONObject().apply {
                put(AUDIO_NASHEED_FILE_NAME_KEY, audioNasheedFileCache.name)
                put(AUDIO_NASHEED_FILE_URL_KEY, audioNasheedFileCache.url)
            }.toString()
        }

        @TypeConverter
        fun toAudioNasheedFile(source: String): AudioNasheedFileCache {
            val json = JSONObject(source)
            return AudioNasheedFileCache(name = json.getString(AUDIO_NASHEED_FILE_NAME_KEY),
                url = json.getString(AUDIO_NASHEED_FILE_URL_KEY))
        }

        @TypeConverter
        fun fromAudioNasheedPoster(audioNasheedPosterCache: AudioNasheedPosterCache): String {
            return JSONObject().apply {
                put(AUDIO_NASHEED_POSTER_NAME_KEY, audioNasheedPosterCache.name)
                put(AUDIO_NASHEED_POSTER_URL_KEY, audioNasheedPosterCache.url)
            }.toString()
        }

        @TypeConverter
        fun toAudioNasheedPoster(source: String): AudioNasheedPosterCache {
            val gson = JSONObject(source)
            return AudioNasheedPosterCache(name = gson.getString(AUDIO_NASHEED_POSTER_NAME_KEY),
                url = gson.getString(AUDIO_NASHEED_POSTER_URL_KEY))
        }

        @TypeConverter
        fun fromGenrePoster(genreCache: CategoryPosterCache): String {
            return JSONObject().apply {
                put(CATEGORY_POSTER_NAME_KEY, genreCache.name)
                put(CATEGORY_POSTER_URL_KEY, genreCache.url)
            }.toString()
        }

        @TypeConverter
        fun toGenrePoster(source: String): CategoryPosterCache {
            val json = JSONObject(source)
            return CategoryPosterCache(
                name = json.getString(CATEGORY_POSTER_NAME_KEY),
                url = json.getString(CATEGORY_POSTER_URL_KEY),
            )
        }


        @TypeConverter
        fun fromReaderPoster(readerCache: ReaderPosterCache): String {
            return JSONObject().apply {
                put(READER_POSTER_NAME_KEY, readerCache.name)
                put(READER_POSTER_URL_KEY, readerCache.url)
            }.toString()
        }

        @TypeConverter
        fun toReaderPoster(source: String): ReaderPosterCache {
            val json = JSONObject(source)
            return ReaderPosterCache(
                name = json.getString(READER_POSTER_NAME_KEY),
                url = json.getString(READER_POSTER_URL_KEY),
            )
        }
    }


    private companion object {
        const val AUDIO_NASHEED_FILE_NAME_KEY = "AUDIO_NASHEED_FILE_NAME_KEY"
        const val AUDIO_NASHEED_POSTER_NAME_KEY = "AUDIO_NASHEED_POSTER_NAME_KEY"
        const val AUDIO_NASHEED_FILE_URL_KEY = "AUDIO_NASHEED_FILE_URL_KEY"
        const val AUDIO_NASHEED_POSTER_URL_KEY = "AUDIO_NASHEED_POSTER_URL_KEY"
        const val CATEGORY_POSTER_NAME_KEY = "CATEGORY_POSTER_NAME_KEY"
        const val CATEGORY_POSTER_URL_KEY = "CATEGORY_POSTER_URL_KEY"
        const val READER_POSTER_NAME_KEY = "READER_POSTER_NAME_KEY"
        const val READER_POSTER_URL_KEY = "READER_POSTER_URL_KEY"
    }
}