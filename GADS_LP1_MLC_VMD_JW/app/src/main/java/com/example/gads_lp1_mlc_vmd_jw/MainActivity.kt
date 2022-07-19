package com.example.gads_lp1_mlc_vmd_jw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gads_lp1_mlc_vmd_jw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.textView.text = viewModel.viewModelNumber.toString()

        binding.button.setOnClickListener {

            viewModel.addNumber()

            binding.textView.text = viewModel.viewModelNumber.toString()
        }
    }
}