package com.example.imagetopdf_app.presentation

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat


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
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onClick
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
        ) {
            items(viewModel.list) { uri ->
                Row(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .clickable {
                            val intent = Intent()
                            intent.setDataAndType(uri, "application/pdf")

                            if (intent.resolveActivity(context.packageManager) != null){
                                context.startActivity(intent)
                            }
                        }
                ) {
                    Text(text = "$uri")
                }

            }
        }
    }


}