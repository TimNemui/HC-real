package com.NguyenBower.hc

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.NguyenBower.hc.ui.theme.Gray500
import com.NguyenBower.hc.ui.theme.HCTheme
import com.NguyenBower.hc.ui.theme.White100
import kotlinx.coroutines.delay

class MainScreen {
    var selectedQuery:String = "Name"

    @Composable
    fun DropdownBox() {
        var expanded by remember { mutableStateOf(false) }
        val items = listOf("Name", "Provider ID", "City", "State", "Zip code", "County")
        var selectedIndex by remember { mutableStateOf(0) }
        Box(modifier = Modifier
            .size(90.dp, 56.dp)
            .background(
                White100
            )
        ) {
            Text(
                items[selectedIndex],
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { expanded = true })

            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Gray500
                    )
            ) {
                items.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        selectedIndex = index
                        expanded = false
                    }) {
                        Text(text = s)
                        selectedQuery = s
                    }
                }

            }
        }
    }

    @Composable
    fun Welcome(){
        Column(modifier = Modifier
            .padding(vertical = 30.dp)) {
            Text("Welcome",fontSize = 40.sp,color = White100)
        }
    }

    @Composable
    fun MyButton(navController: NavController) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            val context = LocalContext.current

            Button(
                onClick = {Global.viewModelG.getDataList()
                    navController.navigate(Screens.ListScreen.route)},
                modifier = Modifier.padding(all = Dp(10F)),
                enabled = true,
                shape = MaterialTheme.shapes.medium
            )
            {
                Text(text = "Test endpoints",color = Color.White)
            }
        }
    }

    @Composable
    fun searchArea(){
        var text by remember { mutableStateOf("") }
        Row() {
            DropdownBox()
            OutlinedTextField(value = text,
                onValueChange = {text=it},
                modifier = Modifier
                    .background(White100))
        }
    }

    @Composable
    fun MainScreen(navController: NavController){

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
                Welcome()
                searchArea()
                MyButton(navController)
            }
        }
    }
}