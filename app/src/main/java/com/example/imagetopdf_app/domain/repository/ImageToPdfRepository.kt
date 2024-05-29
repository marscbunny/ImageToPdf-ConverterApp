package com.example.imagetopdf_app.domain.repository

import android.graphics.Bitmap
import android.net.Uri


interface ImageToPdfRepository{

    fun convertUriToBitmap(uri : Uri) : Bitmap?

    fun convertImageToPdf(bitmap: Bitmap)

}