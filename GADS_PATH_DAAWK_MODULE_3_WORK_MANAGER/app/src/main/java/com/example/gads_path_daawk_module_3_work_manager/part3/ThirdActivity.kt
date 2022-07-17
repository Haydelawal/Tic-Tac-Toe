package com.example.gads_path_daawk_module_3_work_manager.part3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkContinuation
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.douglasstarnes.workchains.DatabaseWriteWorker
import com.douglasstarnes.workchains.NetworkRequestWorker
import com.douglasstarnes.workchains.ObjectDetectionWorker
import com.example.gads_path_daawk_module_3_work_manager.R
import com.example.gads_path_daawk_module_3_work_manager.databinding.ActivitySecondBinding
import com.example.gads_path_daawk_module_3_work_manager.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val workManager = WorkManager.getInstance(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSingleChainSucceed.setOnClickListener {
            val objectDetectionWorkRequest = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()
            val networkRequestWorkRequest = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()
            val databaseWriteWorkRequest = OneTimeWorkRequestBuilder<DatabaseWriteWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()

            workManager.beginWith(objectDetectionWorkRequest)
                .then(networkRequestWorkRequest)
                .then(databaseWriteWorkRequest)
                .enqueue()
        }

        binding.btnSingleChainFail.setOnClickListener {
            val objectDetectionWorkRequest = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()
            val networkRequestWorkRequest = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInputData(workDataOf("SUCCESS" to false))
                .build()
            val databaseWriteWorkRequest = OneTimeWorkRequestBuilder<DatabaseWriteWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()

            workManager.beginWith(objectDetectionWorkRequest)
                .then(networkRequestWorkRequest)
                .then(databaseWriteWorkRequest)
                .enqueue()
        }

        binding.btnGroupChainSucceed.setOnClickListener {
            val objectDetectionWorkRequest1 = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()
            val objectDetectionWorkRequest2 = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()
            val networkRequestWorkRequest = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()
            val databaseWriteWorkRequest = OneTimeWorkRequestBuilder<DatabaseWriteWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()

            workManager.beginWith(listOf(objectDetectionWorkRequest1, objectDetectionWorkRequest2))
                .then(networkRequestWorkRequest)
                .then(databaseWriteWorkRequest)
                .enqueue()
        }

        binding.btnGroupChainFail.setOnClickListener {
            val objectDetectionWorkRequest1 = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()
            val objectDetectionWorkRequest2 = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to false))
                .build()
            val networkRequestWorkRequest = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()
            val databaseWriteWorkRequest = OneTimeWorkRequestBuilder<DatabaseWriteWorker>()
                .setInputData(workDataOf("SUCCESS" to true))
                .build()

            workManager.beginWith(listOf(objectDetectionWorkRequest1, objectDetectionWorkRequest2))
                .then(networkRequestWorkRequest)
                .then(databaseWriteWorkRequest)
                .enqueue()
        }

        binding.btnMultipleChainSucceed.setOnClickListener {

            val objectDetectionWorkRequest1 = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "ONE"))
                .build()
            val objectDetectionWorkRequest2 = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "TWO"))
                .build()
            val networkRequestWorkRequest1 = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "ONE"))
                .build()
            val networkRequestWorkRequest2 = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "TWO"))
                .build()
            val databaseWriteWorkRequest1 = OneTimeWorkRequestBuilder<DatabaseWriteWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "ONE"))
                .build()
            val databaseWriteWorkRequest2 = OneTimeWorkRequestBuilder<DatabaseWriteWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "TWO"))
                .build()

            val recommendation1 = workManager.beginWith(objectDetectionWorkRequest1)
                .then(networkRequestWorkRequest1)
                .then(databaseWriteWorkRequest1)

            val recommendation2 = workManager.beginWith(objectDetectionWorkRequest2)
                .then(networkRequestWorkRequest2)
                .then(databaseWriteWorkRequest2)

            val root = WorkContinuation.combine(listOf(recommendation1, recommendation2))

            root.enqueue()
        }

        binding.btnMultipleChainFail.setOnClickListener {

            val objectDetectionWorkRequest1 = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "ONE"))
                .build()
            val objectDetectionWorkRequest2 = OneTimeWorkRequestBuilder<ObjectDetectionWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "TWO"))
                .build()
            val networkRequestWorkRequest1 = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "ONE"))
                .build()
            val networkRequestWorkRequest2 = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInputData(workDataOf("SUCCESS" to false, "NAME" to "TWO"))
                .build()
            val databaseWriteWorkRequest1 = OneTimeWorkRequestBuilder<DatabaseWriteWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "ONE"))
                .build()
            val databaseWriteWorkRequest2 = OneTimeWorkRequestBuilder<DatabaseWriteWorker>()
                .setInputData(workDataOf("SUCCESS" to true, "NAME" to "TWO"))
                .build()

            val recommendation1 = workManager.beginWith(objectDetectionWorkRequest1)
                .then(networkRequestWorkRequest1)
                .then(databaseWriteWorkRequest1)

            val recommendation2 = workManager.beginWith(objectDetectionWorkRequest2)
                .then(networkRequestWorkRequest2)
                .then(databaseWriteWorkRequest2)

            val root = WorkContinuation.combine(listOf(recommendation1, recommendation2))

            root.enqueue()


        }
    }
}