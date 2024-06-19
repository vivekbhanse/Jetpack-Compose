package com.example.mycompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.models.Quote

@Preview
@Composable
fun QuoteListItems(quote: Quote,onClick:(quote: Quote)->Unit) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ), modifier = Modifier.padding(8.dp).clickable { onClick(quote) }
    ) {
    Row (
        modifier = Modifier.padding(16.dp)
    ){
        Image(imageVector = Icons.Outlined.Favorite, contentDescription = "Quote", colorFilter = ColorFilter.tint(
            Color.White), alignment =  Alignment.TopStart, modifier = Modifier
            .size(40.dp)
            .background(Color.Black) )
        Spacer(modifier = Modifier.padding(4.dp))

        Column(Modifier.weight(1f)) {
            Text(text = quote.quote, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp))
            Box(modifier = Modifier.background(Color(0xFF674376)).fillMaxWidth(.4f).height(1.dp))
            Text(text ="Mr. Scane", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp), color = Color.Gray)
        }
    }


    }
}

