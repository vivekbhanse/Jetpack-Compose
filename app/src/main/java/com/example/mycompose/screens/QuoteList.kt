package com.example.mycompose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.mycompose.models.Quote


@Composable
 fun QuoteList (data:Array<Quote>,onClick:(quote: Quote)->Unit) {
    LazyColumn(content = {
        items(data){
            QuoteListItems(quote = it,onClick)
        }
    })
}