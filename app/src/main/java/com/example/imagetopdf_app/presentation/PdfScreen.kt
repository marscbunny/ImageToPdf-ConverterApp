package com.example.imagetopdf_app.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
fun PdfScreen(
    onClick : () -> Unit
){
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
    ){paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
        ) {

        }
    }




}