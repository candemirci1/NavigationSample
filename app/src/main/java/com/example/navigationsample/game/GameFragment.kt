package com.example.navigationsample.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navigationsample.databinding.FragmentGameBinding

class GameFragment: Fragment() {

    private lateinit var viewModel: GameViewModel

    private var binding: FragmentGameBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater,container,false)
       return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GameViewModel::class.java]
        updateWord()
        updateScore()

        binding?.apply {
            skipButton.setOnClickListener { onSkip() }
            endGameButton.setOnClickListener { onEndGame() }
            correctButton.setOnClickListener { onCorrect() }
        }


    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun onSkip() {
        if (viewModel.word.word.isNotEmpty()) {
            viewModel.onSkip()
            updateScore()
            updateWord()
        } else {
            onEndGame()
        }


    }

    private fun onCorrect() {
        if (viewModel.word.word.isNotEmpty()) {
            viewModel.onCorrect()
            updateScore()
            updateWord()
        } else {
            onEndGame()
        }


    }

    private fun onEndGame() {
       val action = GameFragmentDirections.actionGameFragmentToScoreFragment()
        action.score = viewModel.score
        findNavController().navigate(action)

    }

    private fun updateWord() {
        binding?.wordText?.text = viewModel.word.word
        binding?.forbiddentext?.text = viewModel.word.forbiddenWords.toString()

    }

    private fun updateScore() {
        binding?.scoreText?.text = viewModel.score.toString()
    }
}