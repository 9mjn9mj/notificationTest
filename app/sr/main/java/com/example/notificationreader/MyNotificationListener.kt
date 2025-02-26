package com.example.notificationreader

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class MyNotificationListener : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn?.let {
            val packageName = it.packageName
            val notificationText = it.notification.extras.getCharSequence("android.text")?.toString() ?: ""
            Log.d("NotificationListener", "[$packageName] 알림: $notificationText")

            // 숫자 값 추출
            val number = Regex("\\d+").find(notificationText)?.value
            if (number != null) {
                Log.d("NotificationListener", "추출된 숫자: $number")
                // TODO: 카카오톡 메시지 전송 기능 추가
            }
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        Log.d("NotificationListener", "알림 제거됨: ${sbn?.packageName}")
    }
}
