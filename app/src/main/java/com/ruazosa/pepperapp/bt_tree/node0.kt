package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node0(qiContext: QiContext) {

    Log.d("NODE0_TAG", "Node0 started")
    node1(qiContext)
    if (Variables.nodes["Node1"] == false) {
        Variables.nodes += ("Node0" to false)
        Log.d("NODE0_TAG", "Node0 false")
    } else {
        node2(qiContext)
        if (Variables.nodes["Node2"] == false) {
            Variables.nodes += ("Node0" to false)
            Log.d("NODE0_TAG", "Node0 false")
        } else {
            repeat(qiContext)
            if (!Variables.repeat) {
                Variables.nodes += ("Node0" to false)
                Log.d("NODE0_TAG", "Node0 false")
            } else {
                Variables.nodes += ("Node0" to true)
                Log.d("NODE0_TAG", "Node0 true")
            }
        }
    }

}