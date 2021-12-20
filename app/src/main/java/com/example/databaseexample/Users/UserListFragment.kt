package com.example.databaseexample.Users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseexample.R
import com.example.databaseexample.enitities.User

class UserListFragment: Fragment() {

    lateinit var viewModel: UsersListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_user_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = UsersListViewModelFactory((requireNotNull(this.activity).application))
        viewModel =
            ViewModelProvider(requireActivity(), factory).get(UsersListViewModel::class.java)


        val usersListAdapter = UsersListAdapter(viewModel.users, viewModel)

        viewModel.users.observe(viewLifecycleOwner,
            Observer<List<User>> { usersListAdapter.notifyDataSetChanged() }
        )


        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.users_recyclerView).let {

            it.adapter = usersListAdapter
            it.layoutManager = layoutManager
        }

        view.findViewById<Button>(R.id.button_back_to_form).apply {
            setOnClickListener {
                it.findNavController().navigate(R.id.action_userListFragment_to_userFragment)
            }

            view.findViewById<Button>(R.id.button_user_go_to_klass).apply {
                setOnClickListener {
                    it.findNavController().navigate(R.id.action_userListFragment_to_klassListFragment2)
                }
            }
        }
    }
}