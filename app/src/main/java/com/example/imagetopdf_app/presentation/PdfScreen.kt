package com.example.imagetopdf_app.presentation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfScreen() {

    val pickImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {uri ->


    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ImageToPdf Converter",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    pickImage.launch("image/*")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {



        }
    }


}


/**
 * import android.graphics.BitmapFactory
 * import androidx.compose.runtime.Composable
 * import androidx.compose.runtime.remember
 * import java.io.FileNotFoundException
 *
 * @Composable
 * fun GetImageBitmap(uri: Uri): Bitmap? {
 *   val context = LocalContext.current
 *   return remember(uri) {
 *     try {
 *       val inputStream = context.contentResolver.openInputStream(uri)
 *       val bitmap = BitmapFactory.decodeStream(inputStream)
 *       inputStream?.close()
 *       bitmap
 *     } catch (e: FileNotFoundException) {
 *       // Handle file not found exception
 *       null
 *     }
 *   }
 * }
 *
 */