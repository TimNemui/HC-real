package com.NguyenBower.hc

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.NguyenBower.hc.api.HospitalSchema
import com.NguyenBower.hc.api.dataModel

class RetreiveData {

    @Composable
    fun dataList(dataList:List<dataModel>,navController:NavController){
            LazyColumn(Modifier.onSizeChanged {  }) {
                itemsIndexed(dataList){index,item->
                    ItemRow2(item,navController)
                }
            }
    }
    
    @Composable
    fun ItemRow(item: HospitalSchema, onNavigation: () -> Unit){
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp, start = 5.dp, end = 5.dp)
            .clickable(onClick = onNavigation)
        ){
            Column(modifier = Modifier.fillMaxSize()
            ) {
                Text(text = item.name,fontSize = 25.sp)
                Text(text = item.city +", "+ item.state,fontSize = 18.sp)
            }
        }
    }

@Composable
    fun ItemRow2(item: dataModel,navController:NavController){
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp, start = 5.dp, end = 5.dp)
            .clickable(onClick = { navController.navigate(Screens.InfoScreen.route) })

        ){
            Column(modifier = Modifier.fillMaxSize()
            ) {
                Text(text = item.title,fontSize = 25.sp)
                Text(text = item.id.toString() +", "+ item.userId.toString(),fontSize = 18.sp)
            }
        }
    }

    @Composable
    fun ListScreen(navController:NavController,endpoint:String = "", searchKey:String=""){
        dataList(dataList = Global.datalist,navController)
    }



    @Preview
    @Composable
    fun PreviewList(){
//        ListScreen(onNavigation = { /*TODO*/ })
    }

}