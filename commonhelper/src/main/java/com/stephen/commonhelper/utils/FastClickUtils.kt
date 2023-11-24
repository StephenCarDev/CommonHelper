package com.stephen.commonhelper.utils

object FastClickUtils {

    private var lastClickTime = 0L

    private const val TIMEGAP = 300L

    fun isFastClick(): Boolean {
        val currentClickTime = System.currentTimeMillis()
        if ((currentClickTime - lastClickTime) < TIMEGAP) return true
        lastClickTime = currentClickTime
        return false
    }
}