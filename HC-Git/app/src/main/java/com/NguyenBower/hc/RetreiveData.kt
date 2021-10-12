package com.NguyenBower.hc

import android.icu.lang.UCharacter
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.NguyenBower.hc.Global.Companion.viewModelG
import com.NguyenBower.hc.api.HData
import com.NguyenBower.hc.api.HospitalSchema
import com.NguyenBower.hc.api.dataModel
import kotlinx.coroutines.delay
import java.util.*

class RetreiveData {

    @Composable
    fun dataList(dataList:List<HData>,navController:NavController){
            LazyColumn(Modifier.onSizeChanged {  }) {
                itemsIndexed(dataList){ _, item->
                    ItemRow(item,navController)
                }
            }
    }
    @Composable
    fun dataList2(dataList:List<dataModel>,navController:NavController){
            LazyColumn(Modifier.onSizeChanged {  }) {
                itemsIndexed(dataList){ _, item->
                    ItemRow2(item,navController)
                }
            }
    }
    @Composable
    fun ItemRow(item: HData, navController:NavController){
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp, start = 5.dp, end = 5.dp)
            .clickable(onClick = { navController.navigate(Screens.InfoScreen.route) })
        ){
            Column(modifier = Modifier.fillMaxSize()
            ) {
                Text(text = item.name,fontSize = 18.sp)
                Text(text = item.ownership +", "+ item.address,fontSize = 12.sp)
                Text(text = " ")
                Divider(color = Color.Black, thickness = 0.5.dp)
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
                Divider(color = Color.Black, thickness = 1.dp)
            }
        }
    }

    @Composable
    fun ListScreen(navController:NavController,endpoint:String = "1", searchKey:String=""){
        dataList2(dataList = Global.datalist,navController)
//        dataList(dataList = Global.datalistHospital,navController)
    }


    @Preview
    @Composable
    fun PreviewList(){
//        ListScreen(onNavigation = { /*TODO*/ })
    }

}