package com.example.work

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.work.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this,NextPage::class.java)
            startActivity(intent)
        }
        binding.btnUp.setOnClickListener {
            validateSignUp()
        }
    }


    fun validateSignUp() {
        val name1 = binding.etFirst.text.toString()
        val name2 = binding.etLast.text.toString()
        val pass = binding.etPass.text.toString()
        val confirming = binding.etConfirm.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false

        if (name1.isBlank()) {
            binding.tilFirst.error = "First name is required"
            error = true
        }
        if (name2.isBlank()) {
            binding.tilLast.error = "Last name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is needed"
            error = true
        }
        if (pass.isBlank()) {
            binding.tilPass.error = "Password is needed"
            error = true
        }
        if (confirming.isBlank()) {
            binding.tilConfirm.error = "password confirmation is needed"
            error = true
        }
        if (pass != confirming) {
            binding.tilConfirm.error = "Password and confirmation do not match"
            error = true
        }
        if (!error) {
            Toast.makeText(this, "$name1 $name2 $email", Toast.LENGTH_LONG).show()

        }

    }
}