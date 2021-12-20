package com.example.databaseexample.Klass

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.databaseexample.Klass.AddKlassViewModel
import com.example.databaseexample.R
import com.example.databaseexample.enitities.Klass
import com.example.databaseexample.enitities.User

class KlassFragment: Fragment() {


    private lateinit var viewModel: AddKlassViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val factory=AddUserViewModelFactory(requireActivity().application)
        viewModel=ViewModelProvider(requireActivity()).get(AddKlassViewModel::class.java)
        Log.d("create","create")

        return inflater.inflate(R.layout.fragment_klass,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_add_klass).apply {
            setOnClickListener {
                val klass= Klass(0,"A","23:10:202","23:10:202")
                viewModel.addKlass(klass)
            }
        }


        view.findViewById<Button>(R.id.button_klass_go_to_list).apply {
            setOnClickListener {
               view.findNavController().navigate(R.id.action_klassFragment_to_klassListFragment2)
            }
        }

    }
}
