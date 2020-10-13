package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun invert(qiContext: QiContext){
    GlobalScope.launch {
        Log.d("INVERT_TAG", "invert started")
        continue1(qiContext)
        if(Variables.listening["Continue"] == true){
            Variables.listening += ("Continue" to false)
            Log.d("INVERTED_TAG", "invert false")
        }else{
            Variables.listening += ("Continue" to true)
            Log.d("INVERTED_TAG", "invert true")
        }
    }

}