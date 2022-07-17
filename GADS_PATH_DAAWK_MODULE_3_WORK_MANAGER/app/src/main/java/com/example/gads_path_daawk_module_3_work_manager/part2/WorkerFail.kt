package com.example.gads_path_daawk_module_3_work_manager.part2

import android.content.Context
import android.content.ContextParams
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerFail (context: Context, params: WorkerParameters): Worker(context, params) {

    override fun doWork(): Result {

        return Result.failure()

    }
}