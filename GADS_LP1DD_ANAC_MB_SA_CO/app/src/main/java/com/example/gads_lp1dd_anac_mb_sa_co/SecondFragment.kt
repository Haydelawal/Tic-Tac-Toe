package com.example.gads_lp1dd_anac_mb_sa_co

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gads_lp1dd_anac_mb_sa_co.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
   private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)


        binding.textView1.text = "FirstName: ${args.currentUser.firstName} and LastName: ${args.currentUser.lastName}"

        binding.textView2.text = args.currentUser.firstName.toString()
        binding.textView3.text = args.currentUser.lastName.toString()


        binding.button.setOnClickListener {

            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

}