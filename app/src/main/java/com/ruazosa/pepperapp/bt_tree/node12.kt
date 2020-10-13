package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node12(qiContext: QiContext){
    GlobalScope.launch {
        Log.d("NODE12_TAG", "Node12 started")
        invert(qiContext)
        if(Variables.listening["Continue"] == false){
            Variables.nodes += ("Node12" to false)
            Log.d("NODE12_TAG", "Node12 false")
        }else{
            sayEnd(qiContext)
            if(Variables.saying["End"] == false){
                Variables.nodes += ("Node12" to false)
                Log.d("NODE12_TAG", "Node12 false")
            }else{
                Variables.nodes += ("Node12" to true)
                Log.d("NODE12_TAG", "Node12 true")
            }
        }
    }
}