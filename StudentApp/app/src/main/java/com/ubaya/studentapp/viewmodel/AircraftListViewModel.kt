package com.ubaya.studentapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.studentapp.view.Aircraft

class AircraftListViewModel(application: Application): AndroidViewModel(application) {
    val aircraftsLD = MutableLiveData<ArrayList<Aircraft>>()

    val TAG = "volleyAircraftTag"
    private var queue: RequestQueue? = null

    fun refresh(){
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ANMP/aircrafts.json"
        val stringRequest = StringRequest(Request.Method.GET, url, {
            val sType = object: TypeToken<List<Aircraft>>(){}.type
            val result = Gson().fromJson<List<Aircraft>>(it, sType)
            aircraftsLD.value = result as ArrayList<Aircraft>
        },
        {
            Log.e("aircraftvolley", it.toString())
        })
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}