package com.ubaya.studentapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.studentapp.databinding.AircraftListItemBinding
import com.ubaya.studentapp.databinding.FragmentAircraftBinding
import com.ubaya.studentapp.model.Aircraft

class AircraftListAdapter(val aircraftList: ArrayList<Aircraft>)
    : RecyclerView.Adapter<AircraftListAdapter.AircraftViewHolder>() {
    class AircraftViewHolder(var binding: AircraftListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AircraftViewHolder {
        val binding = AircraftListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AircraftViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return aircraftList.size
    }

    override fun onBindViewHolder(holder: AircraftViewHolder, position: Int) {
        with(holder.binding){
            txtModelName.text = aircraftList[position].model
            txtManufacturer.text = aircraftList[position].manufacturer
            txtCapacity.text = "Capacity: " + aircraftList[position].capacity.toString() + " passengers"
            txtLength.text = "Length: " + aircraftList[position].aircraftSpecs?.length.toString() + " meters"
            txtWingspan.text = "Length: " + aircraftList[position].aircraftSpecs?.wingspan.toString() + " meters"
            txtHeight.text = "Height: " + aircraftList[position].aircraftSpecs?.height.toString() + " meters"

            var passengerClasses = aircraftList[position].passengerClasses
            var passengerClassesString = ""
            if (passengerClasses != null) {
                for(passengerClass in passengerClasses){
                    passengerClassesString += (passengerClass + ", ")
                }
            }
            txtPassengerClasses.text = passengerClassesString
        }
    }

    fun updateAircraftList(newAircraftList: ArrayList<Aircraft>){
        aircraftList.clear()
        aircraftList.addAll(newAircraftList)
        notifyDataSetChanged()
    }

}