package otus.homework.coroutines

import android.util.Log

object CrashMonitor {

    /**
     * Pretend this is Crashlytics/AppCenter
     */
    fun trackWarning(error: Exception) {
        Log.e(TAG, "trackWarning: $error")
    }

    private const val TAG = "CrashMonitor"
}