package com.NguyenBower.hc.repository

import com.NguyenBower.hc.api.HospitalSchema
import com.NguyenBower.hc.api.RetrofitInstance
import com.NguyenBower.hc.api.dataModel
import retrofit2.Response

class Repository {
    suspend fun getData(): Response<dataModel> {
        return RetrofitInstance.api.getEmploy()
    }

    suspend fun getDataList(): Response<List<dataModel>>{
        return RetrofitInstance.api.getEmployList()
    }

    suspend fun getHospital(): Response<HospitalSchema>{
        return RetrofitInstance.api.getHospital()
    }

    suspend fun getHospitalId(parameter: String): Response<HospitalSchema>{
        return RetrofitInstance.api.getProvideId(parameter)
    }

    suspend fun getHospitalName(parameter: String): Response<HospitalSchema>{
        return RetrofitInstance.api.getHospitalName(parameter)
    }

    suspend fun getHospitalCity(parameter: String): Response<HospitalSchema>{
        return RetrofitInstance.api.getHospitalCity(parameter)
    }

    suspend fun getHospitalState(parameter: String): Response<HospitalSchema>{
        return RetrofitInstance.api.getHospitalState(parameter)
    }

    suspend fun getHospitalZip(parameter: String): Response<HospitalSchema>{
        return RetrofitInstance.api.getHospitalZip(parameter)
    }

    suspend fun getHospitalCounty(parameter: String): Response<HospitalSchema>{
        return RetrofitInstance.api.getHospotalCounty(parameter)
    }

}