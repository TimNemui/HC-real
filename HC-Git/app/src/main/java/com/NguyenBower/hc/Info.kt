package com.NguyenBower.hc

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.NguyenBower.hc.ui.theme.HCTheme
import com.NguyenBower.hc.ui.theme.White100

class Info {
    @Composable
    fun displayName(name:String = "This is where name need to be"){

            Text(text = name,color = Color.Black)
    }

    @Composable
    fun displayLocation(location:String = "This is where location need to be"){
        Text(text = location,color = Color.Black)
    }



    @Composable
    fun textContainer(){
        Card(
            backgroundColor = White100,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(top = 90.dp,bottom = 90.dp,start = 10.dp,end = 10.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()) {
                displayName()
                displayLocation()
            }
        }
    }

    @Composable
    fun infoScreen(id:String){
        HCTheme {
            Card(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .fillMaxSize()
            ) {
                Surface(color = MaterialTheme.colors.background) {
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {
                textContainer()
            }
        }
    }
}