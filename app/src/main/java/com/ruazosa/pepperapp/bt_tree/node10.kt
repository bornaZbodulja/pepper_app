package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node10(qiContext: QiContext){
    GlobalScope.launch {
        cBuildingCond()
        Log.d("NODE10_TAG", "Node10 started")

        if(Variables.listening["CBuildingCond"] == false){
            Variables.nodes += ("Node10" to false)
            Log.d("NODE10_TAG", "Node10 false")
        }else{
            node14(qiContext)
            if(Variables.nodes["Node14"] == false){
                Variables.nodes += ("Node10" to false)
                Log.d("NODE10_TAG", "Node10 false")
            }else{
                Variables.nodes += ("Node10" to true)
                Log.d("NODE10_TAG", "Node10 true")
            }
        }
    }
}