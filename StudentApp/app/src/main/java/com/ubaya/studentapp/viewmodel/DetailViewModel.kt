package com.ubaya.studentapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.studentapp.model.Student
import org.json.JSONObject

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()

    val TAG = "volleyStudentDetailTag"
    private var queue: RequestQueue? = null

    fun refresh(id: String){
//        val student1 = Student("16055","Nonie Penny","1998/03/28","5718444778",
//            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//        studentLD.value = student1

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id="+id
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener {
            val sTypeStudent = object: TypeToken<Student>(){}.type
            val response = JSONObject(it)
            val result = Gson().fromJson<Student>(response.toString(), sTypeStudent)
            studentLD.value = result as Student
        },
            Response.ErrorListener {
            Log.e("studentdetailvolley", it.toString())
        })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}