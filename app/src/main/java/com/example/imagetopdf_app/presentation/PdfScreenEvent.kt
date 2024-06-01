package com.example.imagetopdf_app.presentation

import android.graphics.Bitmap
import android.net.Uri


sealed interface PdfScreenEvent{

    data class ImageSelected(val uri : Uri) : PdfScreenEvent
    data class ConvertImageToPdf(val bitmap: Bitmap) : PdfScreenEvent

    data class MultipleImageSelected(val listUri : List<Uri>) : PdfScreenEvent
    data class ConvertMultipleImagesToPdf(val listBitmap : List<Bitmap>) : PdfScreenEvent


}