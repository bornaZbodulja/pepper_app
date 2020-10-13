package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun cBuildingCond() {

    Log.d("CBUILDING_COND", "cBuildingCond block started")
    Variables.listening += ("CBuildingCond" to false)
    if (Variables.word == "c building") {
        Log.d("CBUILDING_RECG", "C building recognised")
        Variables.listening += ("CBuildingCond" to true)
    }

}