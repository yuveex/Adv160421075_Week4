package com.ubaya.studentapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.studentapp.databinding.FragmentAircraftBinding
import com.ubaya.studentapp.viewmodel.AircraftListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AircraftFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AircraftFragment : Fragment() {
    private lateinit var binding: FragmentAircraftBinding
    private lateinit var viewModel: AircraftListViewModel
    private val aircraftListAdapter = AircraftListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_aircraft, container, false)
        binding = FragmentAircraftBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AircraftListViewModel::class.java)
        viewModel.refresh()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = aircraftListAdapter

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.aircraftsLD.observe(viewLifecycleOwner, Observer {
            aircraftListAdapter.updateAircraftList(it)
        })
    }
}