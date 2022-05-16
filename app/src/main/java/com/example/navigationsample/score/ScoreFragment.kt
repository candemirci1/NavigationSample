package com.example.navigationsample.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationsample.databinding.FragmentScoreBinding

class ScoreFragment: Fragment() {
    private val args: ScoreFragmentArgs by navArgs()

    private var binding: FragmentScoreBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreBinding.inflate(inflater,container,false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val score = args.score
        binding?.scoreText?.text = score.toString()

        binding?.playAgainButton?.setOnClickListener {
            val action = ScoreFragmentDirections.actionScoreFragmentToGameFragment()
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}