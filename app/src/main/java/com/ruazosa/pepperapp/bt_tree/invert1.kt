package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun invert1(qiContext: QiContext) {

    Log.d("INVERT1_TAG", "invert1 started")
    Variables.executed = true
    sayChoice2(qiContext)
    if (Variables.saying["Choice2"] == true) {
        Variables.saying += ("Choice2" to false)
        Variables.invert = true
        Log.d("INVERT1_TAG", "invert1 true")
    } else {
        Log.d("INVERT1_TAG", "invert1 false")
    }

}