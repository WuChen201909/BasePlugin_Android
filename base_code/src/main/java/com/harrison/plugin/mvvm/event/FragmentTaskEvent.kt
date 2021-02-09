package com.harrison.plugin.mvvm.event

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.harrison.plugin.mvvm.base.BaseActivityView
import com.harrison.plugin.mvvm.base.BaseFragmentView
import com.harrison.plugin.util.developer.LogUtils

/**
 * 只有在栈顶的页面才能响应事件
 */
class FragmentTaskEvent<T>:MutableLiveData<T>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, {
            if(isFrontTask(owner)){
//                LogUtils.i("响应事件在栈顶")
                observer.onChanged(it)
            }else{
//                LogUtils.i("响应事件不在栈顶")
            }
        })
    }

    /**
     * 判断是否在栈顶
     */
    fun isFrontTask(owner: LifecycleOwner):Boolean{
        var baseActivity:BaseActivityView<*>? = null
        if(owner is BaseActivityView<*>){
            baseActivity = owner
        }
        if(owner is BaseFragmentView<*>){
            baseActivity = owner.requireActivity() as BaseActivityView<*>
        }
        if(baseActivity != null){
            if(owner is BaseActivityView<*> && baseActivity.fragmentViewStack.size == 0){
                return true
            }else if(baseActivity.fragmentViewStack.last() == owner){
                return true
            }else{
                return false
            }
        }
        return true
    }
}