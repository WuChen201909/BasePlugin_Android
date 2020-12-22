package com.harrison.plugin.mvvm.event

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import com.harrison.plugin.constant.HttpResponseCode

/**
 * 专用于网络请求事件处理
 */
class HttpLiveEvent<H> : SingleLiveEvent<HttpLiveEntity<H>>() {

    @MainThread
    fun observe(owner: LifecycleOwner, function:(state: Int,value: H?)->Unit) {
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }
        super.observe(owner, { t ->
            if(t==null){
                function(HttpResponseCode.HTTP_LOCAL_EMPTY,null)
            }else{
                function(t.state,t.data)
            }
        })
    }

    @MainThread
    fun setValue(state:Int,value: H?){
        super.setValue(HttpLiveEntity(state,value))
    }

    companion object {
        private const val TAG = "HttpLiveEvent"
    }
}

class HttpLiveEntity<D>(state: Int,value: D?){
    var state:Int = state
    var data:D? = value
}