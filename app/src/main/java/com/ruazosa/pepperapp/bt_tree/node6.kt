package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node6(qiContext: QiContext){
    GlobalScope.launch {
        Log.d("NODE6_TAG", "Node6 started")
        node12(qiContext)
        if(Variables.nodes["Node12"] == true){
            Variables.nodes += ("Node6" to true)
            Log.d("NODE6_TAG", "Node6 true")
        }else{
            invert1(qiContext)
            if(Variables.saying["Choice2"] == true){
                Variables.nodes += ("Node6" to true)
                Log.d("NODE6_TAG", "Node6 true")
            }else{
                Variables.nodes += ("Node6" to false)
                Log.d("NODE6_TAG", "Node6 false")
            }
        }
    }
}