package com.example.mvvm_database_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mvvm_database_task.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment(R.layout.fragment_update) {

    private val args by navArgs<UpdateFragmentArgs>()

    private val updateViewModel: UpdateViewModel by viewModels {
        UpdateViewModelFactory(
            requireActivity().application,
            RegisterRepository(
                RegisterDatabase.getDatabase(requireContext().applicationContext)
                    .registerDatabaseDao()
            )
        )
    }
    private lateinit var binding: FragmentUpdateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.EdittextUserid.setText(args.currentUser.Username)
        binding.EdittextPassword.setText(args.currentUser.Password)

        binding.ButtonUpdate.setOnClickListener {
            val Username = binding.EdittextUserid.text.toString()
            val Password = binding.EdittextPassword.text.toString()
            val updateUser = RegisterEntity(args.currentUser.Id, Username, Password)

            if (validateInputs(Username, Password)) {
                updateViewModel.updateUserData(updateUser)

                Toast.makeText(
                    requireContext(),
                    "Username and Password Successfully updated",
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_updateFragment_to_userListFragment)

            }
        }
    }

    private fun validateInputs(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            binding.EdittextUserid.error = "Please enter a username"
            return false
        }
        if (password.isEmpty()) {
            binding.EdittextPassword.error = "Please enter a password"
            return false
        }
        return true
    }
}   