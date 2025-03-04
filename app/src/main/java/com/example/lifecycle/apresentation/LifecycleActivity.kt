package com.example.lifecycle.apresentation

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class LifecycleActivity : Activity(), LifecycleOwner{

    private val lifecycleRegistry = LifecycleRegistry(this)


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    override fun onResume() {
        super.onResume()
        lifecycleRegistry.currentState = Lifecycle.State.RESUMED
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    override val lifecycle: Lifecycle
        get() = TODO("Not yet implemented")
}