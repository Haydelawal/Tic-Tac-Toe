package com.example.gads_path_daawk_module_3_work_manager.part2

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerRetry(context: Context, parameters: WorkerParameters): Worker(context, parameters) {

    override fun doWork(): Result {

        println("Still Working: ${WorkStatusSingleton2.workRetries}")

        return if (WorkStatusSingleton2.workRetries < 3) {
            WorkStatusSingleton2.workRetries += 1
            Result.retry()
        } else {
            Result.success()
        }
    }
}