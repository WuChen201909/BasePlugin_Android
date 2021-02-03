package com.harrison.plugin.util.hardware

import android.content.Context
import com.harrison.plugin.mvvm.core.MVVMApplication

/**
 * 屏幕工具类
 */
object MonitorUtils {


    fun init(){

    }


    /**
     * dp转px
     *
     * @param dpValue dp值
     * @return px值
     */
    fun dp2px(dpValue: Float): Int {
        val scale = MVVMApplication.mvvmApplication.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * px转dp
     *
     * @param pxValue px值
     * @return dp值
     */
    fun px2dp(pxValue: Float): Int {
        val scale = MVVMApplication.mvvmApplication.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * sp转px
     *
     * @param spValue sp值
     * @return px值
     */
    fun sp2px(spValue: Float): Int {
        val fontScale = MVVMApplication.mvvmApplication.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    /**
     * px转sp
     *
     * @param pxValue px值
     * @return sp值
     */
    fun px2sp(pxValue: Float): Int {
        val fontScale = MVVMApplication.mvvmApplication.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

}