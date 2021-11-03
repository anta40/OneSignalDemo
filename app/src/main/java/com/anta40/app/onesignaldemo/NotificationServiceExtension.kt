package com.anta40.app.onesignaldemo

import android.content.Context
import android.graphics.Color
import com.onesignal.OSNotificationReceivedEvent
import com.onesignal.OneSignal
import android.text.style.ForegroundColorSpan

import android.text.SpannableString

import android.text.Spannable
import androidx.core.app.NotificationCompat
import java.math.BigInteger


class NotificationServiceExtension: OneSignal.OSRemoteNotificationReceivedHandler {

    override fun remoteNotificationReceived(context: Context?, notificationReceivedEvent: OSNotificationReceivedEvent?) {
        val notification = notificationReceivedEvent?.notification
        var mutableNotification = notification?.mutableCopy()

        mutableNotification!!.setExtender { builder: NotificationCompat.Builder ->
            // Sets the accent color to Green on Android 5+ devices.
            // Accent color controls icon and action buttons on Android 5+. Accent color does not change app title on Android 10+
            builder.color = BigInteger("FF00FF00", 16).toInt()
            // Sets the notification Title to Red
            val spannableTitle: Spannable = SpannableString(notification!!.title)
            spannableTitle.setSpan(
                ForegroundColorSpan(Color.RED),
                0,
                notification!!.title.length,
                0
            )
            builder.setContentTitle(spannableTitle)
            // Sets the notification Body to Blue
            val spannableBody: Spannable = SpannableString(notification!!.body)
            spannableBody.setSpan(
                ForegroundColorSpan(Color.BLUE),
                0,
                notification!!.body.length,
                0
            )
            builder.setContentText(spannableBody)
            //Force remove push from Notification Center after 30 seconds
            builder.setTimeoutAfter(30000)
            builder
        }

        notificationReceivedEvent?.complete(mutableNotification)
    }
}

