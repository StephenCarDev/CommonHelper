package com.stephen.commonhelper.utils

import android.util.Log

var commonTagPrefix = ""

fun setCommonTag(prefix: String = "CommonHelper") {
    commonTagPrefix = prefix
}

fun Any.verboseLog(message: String) {
    Log.v(commonTagPrefix + this.javaClass.simpleName, message)
}

fun Any.debugLog(message: String) {
    Log.d(commonTagPrefix + this.javaClass.simpleName, message)
}

fun Any.infoLog(message: String) {
    Log.i(commonTagPrefix + this.javaClass.simpleName, message)
}

fun Any.warningLog(message: String) {
    Log.w(commonTagPrefix + this.javaClass.simpleName, message)
}

fun Any.errorLog(message: String) {
    Log.e(commonTagPrefix + this.javaClass.simpleName, message)
}