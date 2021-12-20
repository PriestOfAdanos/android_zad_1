package com.example.databaseexample.Klass

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseexample.R
import com.example.databaseexample.enitities.Klass
import androidx.lifecycle.Observer

class KlassListFragment: Fragment() {

    lateinit var viewModel: KlassListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_klass_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory= KlassListViewModelFactory((requireNotNull(this.activity).application))
        viewModel=ViewModelProvider(requireActivity(),factory).
        get(KlassListViewModel::class.java)


        val klassListAdapter= KlassListAdapter(viewModel.klass,viewModel)

        viewModel.klass.observe(viewLifecycleOwner,
            Observer<List<Klass>> { klassListAdapter.notifyDataSetChanged() }
        )


        val layoutManager= LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.klass_recyclerView).let {
            it.adapter=klassListAdapter
            it.layoutManager=layoutManager
        }
        view.findViewById<Button>(R.id.button_back_to_form).apply {
            setOnClickListener {

                it.findNavController().navigate(R.id.action_klassListFragment_to_klassFragment)
            }
        }
    }

}