package com.ubaya.studentapp.model

data class Aircraft(
    var id:String?,
    var model:String?,
    var manufacturer: String?,
    var capacity: Int?,
    var aircraftSpecs: AircraftSpecs?,
    var passangerClasses: ArrayList<String>?,
)

data class AircraftSpecs(
    var length: Double?,
    var wingspan: Double?,
    var height: Double?
)
