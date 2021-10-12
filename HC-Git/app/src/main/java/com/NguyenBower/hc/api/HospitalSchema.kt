package com.NguyenBower.hc.api

    data class HospitalSchema(
       var data: MutableList<HData> = mutableListOf()
    )
data class HData(
    val name: String = "",
    val providerID: String = "",
    val address: String  = "",
    val city: String  = "",
    val state: String  = "",
    val zipCode: Int  = 0,
    val county: String  = "",
    val phoneNumber: String  = "",
    val type: String  = "",
    val ownership: String  = "",
    val emergencyService: Boolean = false
)

