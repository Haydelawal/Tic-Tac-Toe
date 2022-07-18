package com.example.dialogfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dialogfragment.databinding.FragmentFirstBinding
import com.example.dialogfragment.databinding.FragmentMyDialogBinding


class MyDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentMyDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyDialogBinding.inflate(inflater, container, false)

        binding.cancelButton.setOnClickListener {
            dismiss()
        }

        binding.submitButton.setOnClickListener {

            

            Toast.makeText(requireContext(), "Hey", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}