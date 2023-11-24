package com.stephen.commonhelper.base

import android.app.Application
import android.content.Context

// 全局context变量
lateinit var appContext: Context
    private set

fun init(application: Application) {
    appContext = application.applicationContext
}