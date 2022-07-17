package com.example.gads_path_daawk_module_3_work_manager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.work.*
import com.example.gads_path_daawk_module_3_work_manager.databinding.ActivityMainBinding
import com.example.gads_path_daawk_module_3_work_manager.part2.SecondActivity
import com.example.gads_path_daawk_module_3_work_manager.part3.ThirdActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding
    private val workManager = WorkManager.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartWork.setOnClickListener {


            // USING CONSTRAINTS
            val constraints  = Constraints.Builder().setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            // PASSING DATA
            val data = workDataOf("WORK_MESSAGE" to "WORK COMPLETED!")

            val workRequest = OneTimeWorkRequestBuilder<SimpleWorker>()
                .setInputData(data)
                .setConstraints(constraints)
                .build()

            // PERIODIC WORK REQUEST
            val periodicWorkRequest = PeriodicWorkRequestBuilder<SimpleWorker>(
                5, TimeUnit.MINUTES,
                1, TimeUnit.MINUTES
            ).build()
            workManager.enqueue(workRequest)

        }

        binding.btnWorkStatus.setOnClickListener {

            Toast.makeText(
                this,
                "The Work Status Is: ${WorkStatusSingleton.workMessage}",
                Toast.LENGTH_SHORT
            ).show()

        }

        binding.btnResetStatus.setOnClickListener {

            WorkStatusSingleton.workComplete = false

        }

        binding.btnWorkUIThread.setOnClickListener {

            Thread.sleep(10000)
            WorkStatusSingleton.workComplete = true

        }

        binding.btnSwitch2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnSwitch3.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}