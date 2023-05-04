package com.example.data.data.repository.user

import android.content.Context
import com.example.data.data.models.users.UserSaveModel
import com.example.domain.domain.domain.Mapper
import com.example.domain.domain.domain.models.users.UserDomain
import com.example.domain.domain.domain.repositories.UserCacheRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserCacheRepositoryImpl @Inject constructor(
    private val context: Context,
    private val mapperToDomain: Mapper<UserSaveModel, UserDomain>,
    private val mapperToSaveModel: Mapper<UserDomain, UserSaveModel>
) : UserCacheRepository {

    private companion object {
        const val CURRENT_USER_EDITOR_SAVE_KEY = "CURRENT_EDITOR_USER_SAVE_KEY"
        const val CURRENT_USER_SAVE_KEY = "CURRENT_USER_SAVE_KEY"
    }

    override fun fetchCurrentUserFromCache(): Flow<UserDomain> = flow {
        val pref =
            context.getSharedPreferences(CURRENT_USER_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
        val userSaveModel = Gson()
            .fromJson(pref.getString(CURRENT_USER_SAVE_KEY, null), UserSaveModel::class.java)
            ?: UserSaveModel.unknown()
        emit(mapperToDomain.map(userSaveModel))
    }

    override suspend fun saveCurrentUserFromCache(newUser: UserDomain) = context
        .getSharedPreferences(CURRENT_USER_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
        .edit()
        .putString(CURRENT_USER_SAVE_KEY, Gson().toJson(mapperToSaveModel.map(newUser)))
        .commit()

    override suspend fun clear() = context
        .getSharedPreferences(CURRENT_USER_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
        .edit().clear().apply()

}