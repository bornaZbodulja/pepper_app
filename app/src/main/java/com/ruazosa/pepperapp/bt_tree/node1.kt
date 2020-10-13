package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node1(qiContext: QiContext) {

    Log.d("NODE1_TAG", "Node1 started")
    Variables.nodes += ("Node1" to false)
    node4(qiContext)
    if (Variables.nodes["Node4"] == false) {
        Variables.nodes += ("Node1" to false)
        Log.d("NODE1_TAG", "Node1 false")
    } else {
        Variables.nodes += ("Node1" to true)
        Log.d("NODE1_TAG", "Node1 true")
    }

}