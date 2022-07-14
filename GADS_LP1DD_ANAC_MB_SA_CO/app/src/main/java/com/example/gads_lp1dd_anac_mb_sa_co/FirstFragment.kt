package com.example.gads_lp1dd_anac_mb_sa_co

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gads_lp1dd_anac_mb_sa_co.databinding.FragmentFirstBinding
import com.example.gads_lp1dd_anac_mb_sa_co.databinding.FragmentSecondBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {

            val firstName = binding.eT1.text.toString()
            val secondName = binding.eT2.text.toString()

            val user = User(firstName, secondName)

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(user)

            findNavController().navigate(action)
        }

        return binding.root
    }

}