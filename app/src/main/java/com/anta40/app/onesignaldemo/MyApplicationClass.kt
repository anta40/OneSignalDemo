package com.anta40.app.onesignaldemo

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "xxxxx-xxxxx-xxxxx-xxxxx"

class MyApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}