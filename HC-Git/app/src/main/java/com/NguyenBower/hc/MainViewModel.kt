package com.NguyenBower.hc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.NguyenBower.hc.api.HospitalSchema
import com.NguyenBower.hc.api.dataModel
import com.NguyenBower.hc.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val dataResponse:MutableLiveData<Response<dataModel>> = MutableLiveData()
    val dataResponse2:MutableLiveData<Response<List<dataModel>>> = MutableLiveData()
    val dataResponseHospital:MutableLiveData<Response<List<HospitalSchema>>> = MutableLiveData()
    fun getData(){
        viewModelScope.launch {
            val response = repository.getData()
            dataResponse.value = response
        }
    }

    fun getDataList(){
        viewModelScope.launch {
            val response = repository.getDataList()
            dataResponse2.value = response
        }
    }


    fun getHospital(){
        viewModelScope.launch {
            val response = repository.getHospital()
            dataResponseHospital.value = response
        }
    }

    fun getHospitalId(parameter:String){
        viewModelScope.launch {
            val response = repository.getHospitalId(parameter)
            dataResponseHospital.value = response
        }
    }
    fun getHospitalCity(parameter:String){
        viewModelScope.launch {
            val response = repository.getHospitalCity(parameter)
            dataResponseHospital.value = response
        }
    }
    fun getHospitalCounty(parameter:String){
        viewModelScope.launch {
            val response = repository.getHospitalCounty(parameter)
            dataResponseHospital.value = response
        }
    }
    fun getHospitalName(parameter:String){
        viewModelScope.launch {
            val response = repository.getHospitalName(parameter)
            dataResponseHospital.value = response
        }
    }
    fun getHospitalState(parameter:String){
        viewModelScope.launch {
            val response = repository.getHospitalState(parameter)
            dataResponseHospital.value = response
        }
    }
    fun getHospitalIdZip(parameter:String){
        viewModelScope.launch {
            val response = repository.getHospitalZip(parameter)
            dataResponseHospital.value = response
        }
    }
}