package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun teslaCond(){
    GlobalScope.launch {
        Log.d("TESLA_COND", "teslaCond block started")
        Variables.listening += ("teslaCond" to false)
        if (Variables.word == "tesla" || Variables.word == "tesla monument" || Variables.word == "monument"){
            Log.d("TESLA_RECOGNITION", "tesla recognised")
            Variables.listening += ("TeslaCond" to true)
        }
    }
}