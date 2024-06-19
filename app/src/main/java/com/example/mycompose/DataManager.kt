package com.example.mycompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.mycompose.models.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)
    var currentQoute:Quote?=null

    fun loadAssestFromFile(context: Context) {
        val inputStream = context.assets.open("qoute.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQoute=quote
            currentPage.value=Pages.DETAILS
        } else {
            currentPage.value=Pages.LISTING
        }
    }
}

enum class Pages {
    LISTING, DETAILS
}