package com.example.imagetopdf_app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ImageToPdfApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }

}