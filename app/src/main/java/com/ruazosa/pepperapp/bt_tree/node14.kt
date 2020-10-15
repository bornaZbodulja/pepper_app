package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node14(qiContext: QiContext) {

    Log.d("NODE14_TAG", "Node14 started")
    cBuildingConf(qiContext)
    if (Variables.listening["CBuildingConf"] == false) {
        Variables.nodes += ("Node14" to false)
        Log.d("NODE14_TAG", "Node14 false")
    } else {
        talkCBuilding(qiContext)
        if (Variables.saying["CBuilding"] == true) {
            Variables.nodes += ("Node14" to true)
            Log.d("NODE14_TAG", "Node14 true")
        } else {
            Variables.nodes += ("Node14" to false)
            Log.d("NODE14_TAG", "Node14 false")
        }
    }

}