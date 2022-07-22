package com.example.gads_data_binding_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gads_data_binding_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Observing the onTextChanged via activity main.xml
        binding.viewModel = myViewModel
        binding.lifecycleOwner = this


        // Observing the onTextChanged via Main Activity.kt
//        myViewModel.message.observe( this, Observer {
//            binding.textView.text = it
//        })

        binding.editText.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {

                myViewModel.setMessage(char.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}