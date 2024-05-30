package com.example.imagetopdf_app.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfScreen(
    onClick: () -> Unit,
    viewModel: PdfViewModel
) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "PDF APP",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Yellow)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onClick,
                containerColor = Color.Yellow
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black),
        ) {
            viewModel.mapList.forEach { fileName, uri ->
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable {
                                openPdfIntent(context,uri)
                            }
                            .border(width = 2.dp, color = Color.Yellow, shape = RoundedCornerShape(15.dp)),
                    ){
                        Text(
                            text = fileName,
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                }
            }
        }
    }


}

private fun openPdfIntent(context: Context, uri: Uri) {
    val intent = Intent()
    intent.action = Intent.ACTION_VIEW
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    intent.setDataAndType(uri, "application/pdf")

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(Intent.createChooser(intent,"Open Pdf...."))
    }
}