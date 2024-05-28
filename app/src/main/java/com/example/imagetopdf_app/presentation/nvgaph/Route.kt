package com.example.imagetopdf_app.presentation.nvgaph

import kotlinx.serialization.Serializable


@Serializable
sealed class Route{

    @Serializable
    object PdfScreen : Route()
}