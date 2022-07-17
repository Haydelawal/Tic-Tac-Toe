package com.example.gads_path_daawk_module_3_work_manager.part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.gads_path_daawk_module_3_work_manager.WorkStatusSingleton
import com.example.gads_path_daawk_module_3_work_manager.databinding.ActivitySecondBinding
import java.util.concurrent.TimeUnit

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val workManager = WorkManager.getInstance(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWorkFail.setOnClickListener {

            val workerRequest = OneTimeWorkRequestBuilder<WorkerFail>().build()

            workManager.enqueue(workerRequest)
            Toast.makeText(
                this,
                "The Work Status Is: ${WorkStatusSingleton.workMessage}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnWorkRetry.setOnClickListener {

            Toast.makeText(this, "Still Working: ${WorkStatusSingleton2.workRetries}", Toast.LENGTH_SHORT).show()

            val workRequest = OneTimeWorkRequestBuilder<WorkerRetry>()
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    10,
                    TimeUnit.SECONDS
                ).build()
            workManager.enqueue(workRequest)
        }
    }
}