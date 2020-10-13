package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node2(qiContext: QiContext) {

    Log.d("NODE2_TAG", "Node2 started")
    node1(qiContext)
    if (Variables.nodes["Node1"] == false) {
        Variables.nodes += ("Node2" to false)
        Log.d("NODE2_TAG", "Node2 false")
    } else {
        sayChoice1(qiContext)
        if (Variables.saying["Choice1"] == false) {
            Variables.nodes += ("Node2" to false)
            Log.d("NODE2_TAG", "Node2 false")
        } else {
            Variables.nodes += ("Node2" to true)
            Log.d("NODE2_TAG", "Node2 true")
        }
    }

}