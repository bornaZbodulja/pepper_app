package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node7(qiContext: QiContext) {

    Log.d("NODE7_TAG", "Node7 started")
    if (!Variables.recognised) {
        Variables.nodes += ("Node7" to false)
        Log.d("NODE7_TAG", "Node7 false")
    } else {
        saySeeYou(qiContext)
        if (Variables.saying["SeeYou"] == true) {
            Variables.nodes += ("Node7" to true)
            Log.d("NODE7_TAG", "Node7 true")
        } else {
            Variables.nodes += ("Node7" to false)
            Log.d("NODE7_TAG", "Node7 false")
        }
    }
}