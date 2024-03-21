package com.ubaya.studentapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.studentapp.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun refresh(){
        val student1 = Student("16055","Nonie Penny","1998/03/28","5718444778",
            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLD.value = student1
    }
}