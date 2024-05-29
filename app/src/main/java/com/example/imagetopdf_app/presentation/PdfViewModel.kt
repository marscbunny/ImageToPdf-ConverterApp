package com.example.imagetopdf_app.presentation

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.imagetopdf_app.domain.repository.ImageToPdfRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PdfViewModel @Inject constructor(
    private val imageToPdfRepository: ImageToPdfRepository
): ViewModel(){


    var image by mutableStateOf<Bitmap?>(null)

    val list = mutableListOf<Uri>()


    init {
        list += imageToPdfRepository.getAllPdf()
    }


    fun onEvent(event : PdfScreenEvent){
        when(event){
            is PdfScreenEvent.ImageSelected -> {
                val bitmap = imageToPdfRepository.convertUriToBitmap(event.uri)
                image = bitmap
            }

            is PdfScreenEvent.ConvertImageToPdf -> {
                imageToPdfRepository.convertImageToPdf(event.bitmap)
            }
        }
    }

}