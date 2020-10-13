package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun BT(qiContext: QiContext){
    Thread{
        Log.d("BT_TAG", "Behavior tree started")
        node0(qiContext)

        if(Variables.nodes["Node0"] == true){
            Log.d("BT_TAG", "Behavior executed correctly.")
        }
    }.start()
}