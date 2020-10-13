package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node15(qiContext: QiContext){
    GlobalScope.launch {
        Log.d("NODE15_TAG", "Node15 started")
        teslaConf(qiContext)
        if(Variables.listening["TeslaConf"] == false){
            Variables.nodes += ("Node15" to false)
            Log.d("NODE15_TAG", "Node15 false")
        }else{
            talkingBookshop(qiContext)
            if(Variables.saying["Tesla"] == true){
                Variables.nodes += ("Node15" to true)
                Log.d("NODE15_TAG", "Node15 true")
            }else{
                Variables.nodes += ("Node15" to false)
                Log.d("NODE15_TAG", "Node15 false")
            }
        }
    }
}