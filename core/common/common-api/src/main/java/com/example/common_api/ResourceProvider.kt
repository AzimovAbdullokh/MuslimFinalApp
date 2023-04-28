package com.example.common_api

import android.content.Context
import androidx.annotation.StringRes
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

interface ResourceProvider {

    fun getString(@StringRes id: Int): String

    fun fetchErrorMessage(exception: Exception): String

    fun fetchErrorMessage(exception: Throwable): String

    fun fetchIdErrorMessage(exception: Throwable): IdResourceString


    class Base(private val context: Context) : ResourceProvider {

        override fun getString(id: Int) = context.getString(id)

        override fun fetchErrorMessage(exception: Exception): String {
            return when (exception) {
                is UnknownHostException -> getString(R.string.no_internet)
                is SocketTimeoutException -> getString(R.string.no_internet)
                is ConnectException -> getString(R.string.no_internet)
                else -> getString(R.string.generic_error)
            }
        }

        override fun fetchErrorMessage(exception: Throwable): String {
            return when (exception) {
                is UnknownHostException -> getString(R.string.no_internet)
                is SocketTimeoutException -> getString(R.string.no_internet)
                is ConnectException -> getString(R.string.no_internet)
                else -> getString(R.string.generic_error)
            }
        }

        override fun fetchIdErrorMessage(exception: Throwable): IdResourceString =
            when (exception) {
                is UnknownHostException -> IdResourceString(R.string.no_internet)
                is SocketTimeoutException -> IdResourceString(R.string.no_internet)
                is ConnectException -> IdResourceString(R.string.no_internet)
                else -> IdResourceString(R.string.generic_error)
            }

    }
}