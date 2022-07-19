package com.example.progress_bar_c_i_f

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progress_bar_c_i_f.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding
    private var progr = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIncr.setOnClickListener {
            if (progr <= 90) {
                progr +=10
                updateProgressBar()
            }
        }
        binding.buttonDecr.setOnClickListener {
            if (progr >= 10) {
                progr -=10
                updateProgressBar()
            }
        }


    }

    private fun updateProgressBar() {
        binding.progressbar.progress = progr

        binding.text.text = "$progr%"
    }
}