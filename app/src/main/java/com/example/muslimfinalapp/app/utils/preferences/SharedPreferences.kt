package com.example.muslimfinalapp.app.utils.preferences

import android.app.Activity
import android.content.Context
import com.example.muslimfinalapp.app.utils.extensions.CURRENT_STUDENT_EDITOR_SAVE_KEY
import com.example.muslimfinalapp.app.utils.extensions.IS_FILTER_EDITOR_SAVE_KEY
import com.example.muslimfinalapp.app.utils.extensions.IS_FILTER_SAVE_KEY


class SharedPreferences {
//
//    fun saveCurrentUser(user: User, activity: Activity) {
//        activity.getSharedPreferences(CURRENT_STUDENT_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
//            .edit().putString(CURRENT_STUDENT_SAVE_KEY, Gson().toJson(user)).apply()
//    }
//
//    fun getCurrentUser(activity: Context): User? {
//        val pref = activity.getSharedPreferences(CURRENT_STUDENT_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
//        return Gson().fromJson(pref.getString(CURRENT_STUDENT_SAVE_KEY, null), User::class.java)
    }

    fun clearCurrentUser(activity: Activity) =
        activity.getSharedPreferences(CURRENT_STUDENT_EDITOR_SAVE_KEY, Context.MODE_PRIVATE).edit()
            .clear().commit()

    fun saveIsFilter(isFilter: Boolean, context: Context, ) {
        context.getSharedPreferences(IS_FILTER_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
            .edit().putBoolean(IS_FILTER_SAVE_KEY, isFilter).apply()
    }

    fun getIsFilter(activity: Activity): Boolean {
        val pref = activity.getSharedPreferences(IS_FILTER_EDITOR_SAVE_KEY, Context.MODE_PRIVATE)
        return pref.getBoolean(IS_FILTER_SAVE_KEY, false)
    }
