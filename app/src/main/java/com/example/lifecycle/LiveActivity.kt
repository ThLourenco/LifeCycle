package com.example.lifecycle

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycle.streaming.LiveVideo

class LiveActivity: AppCompatActivity() {

    private val liveVideo = LiveVideo()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        lifecycle.addObserver(liveVideo)
    }


}