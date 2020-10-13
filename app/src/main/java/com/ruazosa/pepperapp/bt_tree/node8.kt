package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node8(qiContext: QiContext) {

    Log.d("NODE8_TAG", "Node8 started")
    sayIntroduction(qiContext)
    if (Variables.saying["Introduction"] == false) {
        Variables.nodes += ("Node8" to false)
        Log.d("NODE8_TAG", "Node8 false")
    } else {
        if (!Variables.learned) {
            Variables.nodes += ("Node8" to false)
            Log.d("NODE8_TAG", "Node8 false")
        } else {
            sayMeetYou(qiContext)
            if (Variables.saying["MeetYou"] == false) {
                Variables.nodes += ("Node8" to false)
                Log.d("NODE8_TAG", "Node8 false")
            } else {
                Variables.nodes += ("Node8" to true)
                Log.d("NODE8_TAG", "Node8 true")
            }
        }
    }

}