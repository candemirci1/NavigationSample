package com.example.navigationsample.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationsample.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.playGameButton?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGameFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()

    }


}