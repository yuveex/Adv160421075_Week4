package com.ubaya.studentapp.model

import com.google.gson.annotations.SerializedName

data class Aircraft(
    var id:String?,
    var model:String?,
    var manufacturer: String?,
    var capacity: Number?,
    @SerializedName("dimensions") var aircraftSpecs: AircraftSpecs?,
    var passengerClasses: ArrayList<String>?,
)

data class AircraftSpecs(
    var length: Double?,
    var wingspan: Double?,
    var height: Double?
)
