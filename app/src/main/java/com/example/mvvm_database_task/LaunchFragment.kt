package com.example.mvvm_database_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mvvm_database_task.databinding.FragmentLaunchBinding

class LaunchFragment : Fragment() {
    private lateinit var binding: FragmentLaunchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaunchBinding.inflate(layoutInflater)

        binding.ButtonCreateUser.setOnClickListener() {
            findNavController().navigate(R.id.action_launchFragment_to_createUserFragment)
        }
        binding.ButtonLogin.setOnClickListener() {
            findNavController().navigate(R.id.action_launchFragment_to_loginFragment)
        }

        return binding.root

    }

}