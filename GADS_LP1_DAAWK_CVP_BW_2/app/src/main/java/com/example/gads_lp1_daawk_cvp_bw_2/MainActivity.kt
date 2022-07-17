package com.example.gads_lp1_daawk_cvp_bw_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.gads_lp1_daawk_cvp_bw_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textInputLayout3.setEndIconOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.textInputEditText4.doOnTextChanged { text, start, before, count ->

            if (text!!.length > 10) {
                binding.textInputLayout4.error = "STOP!!"
            } else if (text.length <= 10) {
                binding.textInputLayout4.error = null
            }
        }
    }
}
