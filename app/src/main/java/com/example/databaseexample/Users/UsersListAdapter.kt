package com.example.databaseexample.Users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseexample.R
import com.example.databaseexample.enitities.User

class UsersListAdapter(private val users: LiveData<List<User>>,private val viewModel: UsersListViewModel)
    :RecyclerView.Adapter<UsersListAdapter.UsersListHolder>()
{
    inner class UsersListHolder(private val view: View): RecyclerView.ViewHolder(view)
    {
        val textViewFirstName=view.findViewById<TextView>(R.id.first_name)
        val textViewLastName=view.findViewById<TextView>(R.id.last_name)
        val textViewAge=view.findViewById<TextView>(R.id.age)
        val buttonEdit=view.findViewById<Button>(R.id.button_delete_user)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListHolder {
        val view=LayoutInflater.from(parent.context).
                inflate(R.layout.one_user_row,parent,false)
        return UsersListHolder(view)
    }

    override fun onBindViewHolder(holder: UsersListHolder, position: Int) {
        holder.textViewFirstName.text=users.value?.get(position)?.FirstName
        holder.textViewLastName.text=users.value?.get(position)?.LastName
        holder.textViewAge.text=users.value?.get(position)?.Age.toString()

        holder.buttonEdit.setOnClickListener {
            users.value?.let{ existingUsers->
                viewModel.deleteUser(existingUsers.get(position))

            }
        }
    }

    override fun getItemCount()=users.value?.size?:0

}