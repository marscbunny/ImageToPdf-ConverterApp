package com.example.imagetopdf_app.presentation

import android.net.Uri


sealed interface PdfScreenEvent{

    data class ImageSelected(val uri : Uri) : PdfScreenEvent


}