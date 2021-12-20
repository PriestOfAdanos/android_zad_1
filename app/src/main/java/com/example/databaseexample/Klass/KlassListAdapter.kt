package com.example.databaseexample.Klass

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseexample.R
import com.example.databaseexample.enitities.Klass

class KlassListAdapter(private val klasses: LiveData<List<Klass>>, private val viewModel: KlassListViewModel)
    :RecyclerView.Adapter<KlassListAdapter.KlassListHolder>()
{
    inner class KlassListHolder(private val view: View): RecyclerView.ViewHolder(view)
    {
        val textViewKlassName=view.findViewById<TextView>(R.id.klass_name)
        val textViewKlassStart=view.findViewById<TextView>(R.id.klass_start)
        val textViewKlassEnd=view.findViewById<TextView>(R.id.klass_end)
        val buttonKlassDel=view.findViewById<Button>(R.id.button_delete_klass)
        val buttonKlassDetails=view.findViewById<Button>(R.id.button_klass_details)}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KlassListHolder {
        val view=LayoutInflater.from(parent.context).
                inflate(R.layout.one_klass_row,parent,false)
        return KlassListHolder(view)
    }

    override fun onBindViewHolder(holder: KlassListHolder, position: Int) {
        holder.textViewKlassName.text=klasses.value?.get(position)?.KlassName.toString()
        holder.textViewKlassStart.text=klasses.value?.get(position)?.KlassStart.toString()
        holder.textViewKlassEnd.text=klasses.value?.get(position)?.KlassEnd.toString()

        holder.buttonKlassDel.setOnClickListener {
            klasses.value?.let{ existingKlass->
                viewModel.deleteKlass(existingKlass.get(position))
            }
        }
        holder.buttonKlassDetails.setOnClickListener {
            klasses.value?.let{ existingKlass->
                val bundle = bundleOf("selected" to existingKlass)
                //it.findNavController().navigate(R.id.action_klassListFragment_to_klassDetailsFragment,bundle)
                Log.d("klasa",existingKlass.toString())
            }
        }




    }

    override fun getItemCount()=klasses.value?.size?:0

}