package com.example.muslimfinalapp.app.temporary_screens.sign_in.ui

import android.app.Activity
import android.content.Context
import com.example.muslimfinalapp.app.temporary_screens.models.UserFeatures
import com.google.gson.Gson

const val CURRENT_USER_EDITOR_SAVE_KEY = "CURRENT_EDITOR_USER_SAVE_KEY"
const val CURRENT_USER_SAVE_KEY = "CURRENT_USER_SAVE_KEY"


class SharedPreferences {

    fun saveCurrentUser(user: UserFeatures, activity: Activity) {
        activity.getSharedPreferences(CURRENT_USER_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
            .edit().putString(CURRENT_USER_SAVE_KEY, Gson().toJson(user)).apply()
    }

    fun clearCurrentUser(activity: Activity) =
        activity.getSharedPreferences(CURRENT_USER_EDITOR_SAVE_KEY, Context.MODE_PRIVATE).edit()
            .clear().commit()


}