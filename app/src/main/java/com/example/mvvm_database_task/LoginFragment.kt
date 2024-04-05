package com.example.mvvm_database_task

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvm_database_task.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var registerDatabaseDao: RegisterDatabaseDao

    private val LoginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(
            requireActivity().application,
            RegisterRepository(
                RegisterDatabase.getDatabase(requireContext().applicationContext)
                    .registerDatabaseDao()
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        registerDatabaseDao = RegisterDatabase.getDatabase(requireContext()).registerDatabaseDao()

        binding.ButtonLogin.setOnClickListener {
            val userName = binding.EdittextUserid.text.toString().trim()
            val password = binding.EdittextPassword.text.toString().trim()

            if (validateInputs(userName, password)) {
                LoginViewModel.loginUser(userName, password)

                binding.EdittextUserid.text.clear()
                binding.EdittextPassword.text.clear()
            }
        }

        LoginViewModel.loginResult.observe(viewLifecycleOwner) { result ->
            if (result) {

                findNavController().navigate(R.id.action_loginFragment_to_userListFragment)
            } else {
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT)
                    .show()


            }
        }
    }

    private fun validateInputs(userName: String, password: String): Boolean {
        if (userName.isEmpty()) {
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