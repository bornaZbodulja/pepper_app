package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun bookshopCond() {

    Log.d("BOOKSHOP_COND", "bookshopCond block started")
    Variables.listening += ("BookshopCond" to false)
    if (Variables.word == "bookshop") {
        Log.d("BOOKSHOP_RECOGNITION", "bookshop recognised")
        Variables.listening += ("BookshopCond" to true)
    }

}