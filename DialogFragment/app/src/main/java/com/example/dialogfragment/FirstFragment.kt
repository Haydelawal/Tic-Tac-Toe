package com.example.dialogfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.dialogfragment.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private  var _supportFragmentManager: FragmentManager? = null
    private val supportFragmentManager get() = _supportFragmentManager!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)

      binding.button.setOnClickListener {

//          var dialog = MyDialogFragment()
//          dialog.showsDialog

          val action = FirstFragmentDirections.actionFirstFragmentToMyDialogFragment()
          findNavController().navigate(action)
      }

        return binding.root
    }

}