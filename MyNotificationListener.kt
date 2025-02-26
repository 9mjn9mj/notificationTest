package com.example.notificationreader

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class MyNotificationListener : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn?.let {
            val packageName = it.packageName  // 알림을 보낸 앱 패키지명
            val notificationText = it.notification.extras.getCharSequence("android.text")?.toString() ?: ""
            Log.d("NotificationListener", "[$packageName] 알림: $notificationText")

            // 숫자 추출 (정규식)
            val number = Regex("\\d+").find(notificationText)?.value
            if (number != null) {
                Log.d("NotificationListener", "추출된 숫자: $number")
                // TODO: 여기서 카카오톡으로 숫자 보내기 구현
            }
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        Log.d("NotificationListener", "알림 제거됨: ${sbn?.packageName}")
    }
}
