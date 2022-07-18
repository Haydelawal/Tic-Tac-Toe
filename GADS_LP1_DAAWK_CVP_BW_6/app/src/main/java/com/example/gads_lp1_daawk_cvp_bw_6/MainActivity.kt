package com.example.gads_lp1_daawk_cvp_bw_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.gads_lp1_daawk_cvp_bw_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding

    var startPoint = 0
    var endPoint = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

                if (seekBar != null) {
                    startPoint = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    endPoint = seekBar.progress
                }
            }
        })
    }
}