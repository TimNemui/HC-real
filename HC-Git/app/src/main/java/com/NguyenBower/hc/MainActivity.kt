package com.NguyenBower.hc

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.NguyenBower.hc.Global.Companion.datalist
import com.NguyenBower.hc.api.dataModel
import com.NguyenBower.hc.repository.Repository
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    val scee = RetreiveData()
    val hommee = MainScreen()
    private lateinit var viewModelX: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModelX = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModelX.getDataList()
        viewModelX.dataResponse2.observe(this, Observer { response ->
            if(response.isSuccessful) {
                val result = response.body()
                if (result != null) {
                    datalist = result
                    result.forEach{
                        Log.d("singleR", it.title)
                        Log.d("singleR", it.userId.toString())
                    }
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
        var datalist: List<dataModel> = mutableListOf()
    }
}

