package com.NguyenBower.hc.api

    data class HospitalSchema(
        val name: String = "",
        val providerID: String = "",
        val address: String  = "",
        val city: String  = "",
        val state: String  = "",
        val zipCode: Int  = 0,
        val county: String  = "",
        val phoneNumber: Int  = 0,
        val type: String  = "",
        val ownership: String  = "",
        val emergencyService: Boolean = false
    )

