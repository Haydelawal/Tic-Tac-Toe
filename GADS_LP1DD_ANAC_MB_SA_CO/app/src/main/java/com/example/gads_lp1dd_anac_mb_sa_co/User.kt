package com.example.gads_lp1dd_anac_mb_sa_co

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize

//@Parcelize

@Parcelize
 data class User(

    val firstName: String,
    val lastName: String
) : Parcelable
