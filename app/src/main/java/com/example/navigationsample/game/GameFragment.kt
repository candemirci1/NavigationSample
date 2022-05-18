package com.example.navigationsample.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.navigationsample.databinding.FragmentGameBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            viewModel.word.collect {
                if(it.word.isNotEmpty()){
                    updateWord()
                    updateScore()
                } else{
                    onEndGame()
                }

            }
        }

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
            viewModel.onSkip()

    }
    private fun onCorrect() {
            viewModel.onCorrect()
    }

    private fun onEndGame() {
       val action = GameFragmentDirections.actionGameFragmentToScoreFragment()
        action.score = viewModel.score
        findNavController().navigate(action)

    }

    private fun updateWord() {
        binding?.wordText?.text = viewModel.word.value.word
        binding?.forbiddentext?.text = viewModel.word.value.forbiddenWords.toString()

    }

    private fun updateScore() {
        binding?.scoreText?.text = viewModel.score.toString()
    }
}