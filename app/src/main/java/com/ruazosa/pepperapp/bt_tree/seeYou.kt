package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun saySeeYou(qiContext: QiContext){
    GlobalScope.launch {
        Variables.saying += ("SeeYou" to false)
        Log.d("SEEYOU_TAG", "saySeeYou block started")
        
    }
}