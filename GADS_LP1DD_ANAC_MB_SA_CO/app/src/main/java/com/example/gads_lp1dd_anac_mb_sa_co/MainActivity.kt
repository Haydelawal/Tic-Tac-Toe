package com.example.gads_lp1dd_anac_mb_sa_co

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gads_lp1dd_anac_mb_sa_co.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}