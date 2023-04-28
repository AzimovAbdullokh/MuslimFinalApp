package com.example.muslimfinalapp.app

import android.app.Application
import com.example.data.cloud.service.utils.Utils.APPLICATION_ID
import com.example.data.cloud.service.utils.Utils.CLIENT_KEY
import com.parse.Parse
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import com.yariksoffice.lingver.Lingver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        applicationScope =
            CoroutineScope(context = SupervisorJob() + Dispatchers.Main)

        Lingver.init(this)

        Parse.enableLocalDatastore(this)
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(APPLICATION_ID)
                .clientKey(CLIENT_KEY)
                .server("https://parseapi.back4app.com")
                .build()
        )
    }
    companion object {
        lateinit var applicationScope: CoroutineScope
    }
}