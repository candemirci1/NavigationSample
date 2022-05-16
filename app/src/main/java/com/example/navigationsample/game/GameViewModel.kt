package com.example.navigationsample.game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    var word = ""
    var score = 0

   private var wordlist: MutableList<String> = mutableListOf()

    init {
        createList()
        onNextWord()
    }

    fun onSkip() {
        if (wordlist.isNotEmpty()){
            score--
        }
        onNextWord()

    }

    fun onCorrect() {
        if(wordlist.isNotEmpty()) {
            score++
        }
        onNextWord()

    }

     private fun  createList () {
         wordlist = mutableListOf(
            "papatya",
            "gül",
            "orkide",
            "baklava",
            "kadayıf",
            "kazandibi",
            "kadın",
            "erkek",
            "çoluk",
            "çocuk",
            "hıyar",
            "okey",
            "tavla"
        )
        wordlist.shuffle()

    }

    fun onNextWord() {
        word = if(wordlist.isNotEmpty()) {
            wordlist.removeAt(0)
        } else {
            ""
        }
    }

}