package ru.handsapp.template.app.utils

import android.util.Log
import ru.handsapp.template.BuildConfig

class LogHandler {

    companion object {
        fun d(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, message)
            }
        }

        fun w(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, message)
            }
        }
    }
}