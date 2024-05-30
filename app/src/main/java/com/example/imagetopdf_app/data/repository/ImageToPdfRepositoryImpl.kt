package com.example.imagetopdf_app.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.imagetopdf_app.domain.repository.ImageToPdfRepository
import java.io.File
import java.io.FileOutputStream


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
        val docsFolder =
            File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString())
        if (!docsFolder.exists()) {
            docsFolder.mkdir()
        }
        val timeInMills = System.currentTimeMillis()
        val file = File(docsFolder.absoluteFile, "$timeInMills.pdf")

        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(bitmap.width, bitmap.height, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        val paint = Paint()
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        pdfDocument.finishPage(page)
        pdfDocument.writeTo(FileOutputStream(file))
        pdfDocument.close()

        Toast.makeText(context, "pdf created successfully", Toast.LENGTH_LONG).show()


    }


    override fun getAllPdfAsMap() : Map<String,Uri>{
        val folder = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString())
        val map = mutableMapOf<String,Uri>()
        if (folder.exists()){
            val files = folder.listFiles()
            files.reverse()
            for (file in files){
                val name = file.name
                val uri = FileProvider.getUriForFile(
                    context,
                    "com.example.imagetopdf_app.fileprovider",
                    file
                )
                map[file.name] = uri
            }
        }
        return map

    }


}