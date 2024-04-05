package com.example.mvvm_database_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login_mvvm_task.userList.MyViewHolder
import com.example.login_mvvm_task.userList.UserListViewFactory
import com.example.login_mvvm_task.userList.UserListViewModel
import com.example.mvvm_database_task.databinding.FragmentUserListBinding
import kotlinx.coroutines.launch

class UserListFragment : Fragment(R.layout.fragment_user_list) {
    lateinit var adapter: MyViewHolder
    private lateinit var binding: FragmentUserListBinding
    private val userListViewModel: UserListViewModel by viewModels {
        UserListViewFactory(
            requireActivity().application,
            RegisterRepository(
                RegisterDatabase.getDatabase(requireContext().applicationContext)
                    .registerDatabaseDao()
            )
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserListBinding.bind(view)

        adapter = MyViewHolder()
        binding.designRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.designRecyclerview.adapter = adapter



        lifecycleScope.launch {
            userListViewModel.userList.collect { userList: List<RegisterEntity> ->
                adapter.submitList(userList)
            }
        }
    }
}

