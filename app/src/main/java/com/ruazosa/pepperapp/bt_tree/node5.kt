package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node5(qiContext: QiContext) {

    node9(qiContext)
    Log.d("NODE5_TAG", "Node5 started")
    if (Variables.nodes["Node9"] == true) {
        Variables.nodes += ("Node5" to true)
        Log.d("NODE5_TAG", "Node5 true")
    } else {
        node10(qiContext)
        if (Variables.nodes["Node10"] == true) {
            Variables.nodes += ("Node5" to true)
        } else {
            node11(qiContext)
            if (Variables.nodes["Node11"] == true) {
                Variables.nodes += ("Node5" to true)
                Log.d("NODE5_TAG", "Node5 true")
            } else {
                Variables.nodes += ("Node5" to false)
            }
        }
    }

}