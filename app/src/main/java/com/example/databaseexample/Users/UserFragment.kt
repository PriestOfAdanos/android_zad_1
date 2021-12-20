package com.example.databaseexample.Users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.databaseexample.R
import com.example.databaseexample.enitities.User

class UserFragment: Fragment() {


    private lateinit var viewModel: AddUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      //val factory=AddUserViewModelFactory(requireActivity().application)
      viewModel=ViewModelProvider(requireActivity()).
                   get(AddUserViewModel::class.java)


        return inflater.inflate(R.layout.fragment_user,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_add_user).apply {
            setOnClickListener {
                    val user=User(0,"A","Z",23)
                    viewModel.addUser(user)
                }
            }


        view.findViewById<Button>(R.id.button_user_go_to_list).apply {
            setOnClickListener {
                view.findNavController().navigate(R.id.action_userFragment_to_userListFragment)
            }
        }



}
}

