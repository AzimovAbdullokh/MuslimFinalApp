package com.example.common_impl

import androidx.fragment.app.FragmentActivity


interface ActivityRequired {

    fun onCreated(activity: FragmentActivity)

    fun onStarted()

    fun onStopped()

    fun onDestroyed()

}