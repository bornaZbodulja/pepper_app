package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node11(qiContext: QiContext){
    GlobalScope.launch {

        Log.d("NODE11_TAG", "Node11 started")
        teslaCond()
        if(Variables.listening["TeslaCond"] == false){
            Variables.nodes += ("Node11" to false)
            Log.d("NODE11_TAG", "Node11 false")
        }else{
            node15(qiContext)
            if(Variables.nodes["Node15"] == false){
                Variables.nodes += ("Node11" to false)
                Log.d("NODE11_TAG", "Node11 false")
            }else{
                Variables.nodes += ("Node11" to true)
                Log.d("NODE11_TAG", "Node11 true")
            }
        }
    }
}