package com.example.navigationsample.game

import androidx.lifecycle.ViewModel
import com.example.navigationsample.model.Word

class GameViewModel : ViewModel() {

    var word = Word("", listOf())
    var score = 0

   private var wordlist: MutableList<Word> = mutableListOf()

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
            Word("papatya", listOf("cicek","beyaz","toprak")),
             Word("gül", listOf("kırmızı","diken","aşk")),
             Word("orkide", listOf("pahalı","zarif","sevgili")),
             Word("baklava", listOf("şerbet","tatlı","kalori")),
             Word("kadayıf", listOf("tel","şerbet","kaymak")),
             Word("kazandibi", listOf("cadı","tatlı","süt")),
             Word("kadın", listOf("erkek","insan","cinsiyet")),
             Word("erkek", listOf("kadın","insan","cinsiyet")),
             Word("tavla", listOf("pul","zar","kapı")),
             Word("çocuk", listOf("küçük","bebek","insan"))
         )
        wordlist.shuffle()

    }

    private fun onNextWord() {
        word = if(wordlist.isNotEmpty()) {
            wordlist.removeAt(0)
        } else {
            Word("", listOf())
        }
    }

}

