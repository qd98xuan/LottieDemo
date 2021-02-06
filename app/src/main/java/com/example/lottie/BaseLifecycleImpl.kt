package com.example.lottie

import android.util.Log
import androidx.lifecycle.LifecycleOwner

open class BaseLifecycleImpl:BaseLifecycle{
    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        Log.i("lifecycle","onCreate")
    }

    override fun onStop(lifecycleOwner: LifecycleOwner) {
        Log.i("lifecycle","stop")
    }

    override fun onDestory(lifecycleOwner: LifecycleOwner) {
        Log.i("lifecycle","destory")
        onDestory(lifecycleOwner)
    }
}