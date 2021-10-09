package com.NguyenBower.hc.api

import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET("/posts/1")
    suspend fun getEmploy(): Response<dataModel>

    @GET("/posts")
    suspend fun getEmployList(): Response<List<dataModel>>


    @GET ("/hospitals?")
    suspend fun getHospital(): Response<List<HospitalSchema>>

    @GET ("/hospitals?providerId={provideId}")
    suspend fun getProvideId(@Path("provideId") providerId:String): Response<List<HospitalSchema>>

    @GET ("/hospitals?name={name}")
    suspend fun getHospitalName(@Path ("name")name:String): Response<List<HospitalSchema>>

    @GET ("/hospitals?city={city}")
    suspend fun getHospitalCity(@Path ("city")city:String): Response<List<HospitalSchema>>

    @GET ("/hospitals?state={state}")
    suspend fun getHospitalState(@Path ("state")state:String): Response<List<HospitalSchema>>

    @GET ("/hospitals?zipCode={zipCode}")
    suspend fun getHospitalZip(@Path ("zipCode")zipCode:String): Response<List<HospitalSchema>>

    @GET ("/hospitals?county={county}")
    suspend fun getHospotalCounty(@Path ("county")county:String): Response<List<HospitalSchema>>
}