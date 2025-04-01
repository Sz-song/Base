package com.tools.base.util

import android.util.Log


object L {
    private const val TAG = "MY_LOG"
    
    fun d(msg: String?) {
        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.d(
            TAG, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.d(TAG, msg!!)
    }

    fun d(tag: String?, msg: String?) {
        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.d(
            tag, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.d(tag, msg!!)

    }

    fun e(msg: String?) {
        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.e(
            TAG, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.e(TAG, msg!!)
    }
    fun e(msg: Int?) {
        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.e(
            TAG, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.e(TAG, msg!!.toString())
    }

    fun e(tag: String?, msg: String?) {
        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.e(
            tag, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.e(tag, msg!!)
    }

    fun i(msg: String?) {

        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.i(
            TAG, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.i(TAG, msg!!)
    }

    fun i(tag: String?, msg: String?) {
        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.i(
            tag, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.i(tag, msg!!)
    }

    fun w(msg: String?) {

        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.w(
            TAG, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.w(TAG, msg!!)
    }

    fun w(tag: String?, msg: String?) {
        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.w(
            tag, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.w(tag, msg!!)

    }

    fun v(msg: String?) {

        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.v(
            TAG, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.v(TAG, msg!!)
    }

    fun v(tag: String?, msg: String?) {
        
        val targetStackTraceElement = getTargetStackTraceElement()
        Log.v(
            tag, "(" + targetStackTraceElement?.fileName + ":"
                    + targetStackTraceElement?.lineNumber + ")"
        )
        Log.v(tag, msg!!)
    }

    private fun getTargetStackTraceElement(): StackTraceElement? {
        var targetStackTrace: StackTraceElement? = null
        var shouldTrace = false
        val stackTrace = Thread.currentThread().stackTrace
        for (stackTraceElement in stackTrace) {
            val isLogMethod = stackTraceElement.className == L::class.java.name
            if (shouldTrace && !isLogMethod) {
                targetStackTrace = stackTraceElement
                break
            }
            shouldTrace = isLogMethod
        }
        return targetStackTrace
    }
}