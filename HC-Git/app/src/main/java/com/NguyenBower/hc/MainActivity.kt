package com.NguyenBower.hc

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.NguyenBower.hc.Global.Companion.datalist
import com.NguyenBower.hc.Global.Companion.datalistHospital
import com.NguyenBower.hc.Global.Companion.viewModelG
import com.NguyenBower.hc.api.HData
//import com.NguyenBower.hc.MainActivity.Global.Companion.datalistHospital
import com.NguyenBower.hc.api.HospitalSchema
import com.NguyenBower.hc.api.dataModel
import com.NguyenBower.hc.repository.Repository



class MainActivity : ComponentActivity() {
    private lateinit var viewModelX: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModelX = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModelG = viewModelX
//        viewModelG.getDataList()
//        viewModelX.getHospital()
        viewModelG.dataResponseHospital.observe(this, { response ->
            Log.d("Check",viewModelG.dataResponseHospital.toString())
            if(response.isSuccessful) {
                val result = response.body()
                if (result != null) {
//                    Log.d("Catch",result.data.toString())
                    Log.d("Catch",result.toString())
                }
                if (result != null) {
//                    datalist = result
                    datalistHospital = result.data
                }
            }else{
                Log.d("Response2",response.errorBody().toString())

            }
        })
        setContent {
           Navigation()

        }
    }
}

class Global:Application(){
    companion object{
        lateinit var viewModelG: MainViewModel
        lateinit var searchKeyM: String
        var categoryG: String = ""
        var datalist: List<dataModel> = mutableListOf()
        var datalistHospital: List<HData> = mutableListOf()
    }
}

