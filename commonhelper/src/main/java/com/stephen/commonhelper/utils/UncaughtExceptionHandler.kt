package com.stephen.commonhelper.utils

import android.os.Process
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

object UncaughtExceptionHandler : Thread.UncaughtExceptionHandler {

    fun init() {
        // 设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    /**
     * 未捕获的exception，走这个回调在这里处理兜底策略
     */
    override fun uncaughtException(t: Thread, e: Throwable) {
        infoLog("uncaughtException threadName: ${t.name} exception: ${e.message}")

        CoroutineScope(Dispatchers.IO).launch {
            infoLog("uncaughtException catched! 处理收尾工作")
            /**
             * TODO
             */
            delay(3000L)
            // 退出程序
            Process.killProcess(Process.myPid())
            exitProcess(1)
        }
    }
}