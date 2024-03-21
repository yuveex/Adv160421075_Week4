package com.ubaya.studentapp.model

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("id") var id:String?,
    @SerializedName("student_name") var name:String?,
    @SerializedName("birth_of_date") var dob:String?,
    @SerializedName("phone") var phone:String?,
    @SerializedName("photo_url") var photoUrl:   String?
)
