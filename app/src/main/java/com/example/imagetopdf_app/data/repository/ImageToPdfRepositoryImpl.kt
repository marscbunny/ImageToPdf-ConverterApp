package com.example.imagetopdf_app.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.example.imagetopdf_app.domain.repository.ImageToPdfRepository


class ImageToPdfRepositoryImpl(
    private val context : Context
): ImageToPdfRepository{


    override fun convertUriToBitmap(uri: Uri): Bitmap? {
        return try {

        }catch (e : Exception){

        }
    }


}