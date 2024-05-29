package com.example.imagetopdf_app.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Environment
import androidx.compose.ui.graphics.Paint
import com.example.imagetopdf_app.domain.repository.ImageToPdfRepository
import java.io.File


class ImageToPdfRepositoryImpl(
    private val context: Context
) : ImageToPdfRepository {


    override fun convertUriToBitmap(uri: Uri): Bitmap? {
        return try {
            val inputStream = context.contentResolver.openInputStream(uri).use { inputStream ->
                val bitmap = BitmapFactory.decodeStream(inputStream)
                inputStream?.close()
                bitmap
            }
            inputStream
        } catch (e: Exception) {
            null
        }
    }

    override fun convertImageToPdf(bitmap: Bitmap) {
        val docsFolder = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString())
        if (!docsFolder.exists()){
            docsFolder.mkdir()
        }

        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(300,600,1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        val paint = Paint()



    }


}