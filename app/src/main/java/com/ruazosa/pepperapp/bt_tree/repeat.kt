package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun repeat(qiContext: QiContext) {
    Log.d("REPEAT_TAG", "repeat started")
    while (true) {
        node3(qiContext)
        if (Variables.nodes["Node3"] == true) {
            Variables.repeat = true
            Log.d("REPEAT_TAG", "repeat true")
            break
        } else if (Variables.nodes["Node3"] == false) {
            if (Variables.executed && !Variables.invert) {
                Variables.repeat = false
                Log.d("REPEAT_TAG", "repeat false")
                break
            }
            Thread.sleep(1000)
        }
    }

}