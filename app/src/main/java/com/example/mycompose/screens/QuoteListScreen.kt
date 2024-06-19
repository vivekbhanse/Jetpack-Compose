package com.example.mycompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mycompose.models.Quote

@Composable
fun QouteListScreen(data:Array<Quote>,onClick:(quote: Quote)->Unit){
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
        )
        QuoteList(data = data,onClick)

        }

}