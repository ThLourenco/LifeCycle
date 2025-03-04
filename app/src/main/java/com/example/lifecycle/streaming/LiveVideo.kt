package com.example.lifecycle.streaming

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LiveVideo: DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        //play live
    }


    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        //pausa o video
    }


    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        //liberar memora do video
    }
                                                                      }