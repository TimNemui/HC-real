package com.NguyenBower.hc

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.NguyenBower.hc.ui.theme.HCTheme

class Previews {
    val mainScreen = MainScreen()
    val info = Info()

    @Preview("Main Screen welcoming users")
    @Composable
    fun PreviewStart(){
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
                    .padding(20.dp)

            ) {
                mainScreen.Welcome()
//                mainScreen.MyButton()
            }
        }
    }


    @Preview("Info Screen")
    @Composable
    fun PreviewInfo(){
//        info.infoScreen()
    }
}