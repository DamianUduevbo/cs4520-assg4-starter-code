package com.cs4520.assignment4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment4.R
import com.cs4520.assignment4.databinding.FragmentLoginBinding

// using viewbindings to access the views
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private var usernameInput: EditText? = null
    private var passwordInput: EditText? = null
    private var loginButton: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        val loginButton = view.findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            onLoginButtonPressed()
        }

        return view
    }

    // use the action 'action_loginFragment_to_productListFragment' to navigate to the product list
    // if username and password both equal "admin", navigate to the product list
    fun onLoginButtonPressed() {
        usernameInput = binding.usernameEditText
        passwordInput = binding.passwordEditText

        val username = usernameInput?.text.toString()
        val password = passwordInput?.text.toString()

        if (username == "admin" && password == "admin") {
            // clear the fields before navigating to the product list
            usernameInput?.setText("")
            passwordInput?.setText("")
            findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
        } else {
            // display a toast message to the user
            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }
}

/*
class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("LoginFragment", "onCreateView")
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val loginButton = view.findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            onLoginButtonPressed()
        }

        return view
    }

    // use the action 'action_loginFragment_to_productListFragment' to navigate to the product list
    // if username and password both equal "admin", navigate to the product list
    fun onLoginButtonPressed() {
        val username = view?.findViewById<EditText>(R.id.usernameEditText)?.text.toString()
        val password = view?.findViewById<EditText>(R.id.passwordEditText)?.text.toString()

        if (username == "admin" && password == "admin") {
            // clear the fields before navigating to the product list
            view?.findViewById<EditText>(R.id.usernameEditText)?.setText("")
            view?.findViewById<EditText>(R.id.passwordEditText)?.setText("")
            findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
        } else {
            // display a toast message to the user
            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }
}
*/