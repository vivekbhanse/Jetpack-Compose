package com.example.mycompose.screens

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.DataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch{
            delay(1000)
        DataManager.loadAssestFromFile(applicationContext)
        }
        setContent {
//            NotificationScreen()
            QouteApp()
        }
    }
}



@Composable
fun NotificationScreen() {
    var count: MutableState<Int> = rememberSaveable {
        mutableStateOf(0)
    }
    NotificationCounter(count)

}

@Composable
fun NotificationCounter(count: MutableState<Int>) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have sent ${count.value} notifications")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            count.value++
            Log.d("clicked Send", "count : ${count.value.toString()}")

        }) {
            Text(text = "Send Notifications")

        }
        Spacer(modifier = Modifier.height(10.dp))
        MessageBar(count)
    }
}


@Composable
fun MessageBar(count: MutableState<Int>) {
    Card(shape = RoundedCornerShape(20.dp),elevation = CardDefaults.cardElevation(
        defaultElevation = 10.dp,
    )) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(imageVector = Icons.Outlined.Favorite, contentDescription ="" )
            Text(text = "Message send so far - ${count.value}")
        }
    }
}
@Preview(showSystemUi = true)
@Composable

fun QouteApp(){
    if (DataManager.isDataLoaded.value){
        QouteListScreen(data = DataManager.data) {
            
        }
    }else{
        Box( contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)){
            Text(text = "Loading ...", style = MaterialTheme.typography.headlineSmall)
        }
    }
}