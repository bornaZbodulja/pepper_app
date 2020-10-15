package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext

fun node5(qiContext: QiContext) {

    Log.d("NODE5_TAG", "Node5 started")

    when(Variables.word){
        "bookshop" ->{
            node9(qiContext)
            if (Variables.nodes["Node9"] == true) {
                Variables.nodes += ("Node5" to true)
                Log.d("NODE5_TAG", "Node5 true")
            }else{
                Variables.nodes += ("Node5" to false)
                Log.d("NODE5_TAG", "Node5 false")
            }
        }

        "tesla" ->{
            node11(qiContext)
            if (Variables.nodes["Node10"] == true) {
                Variables.nodes += ("Node5" to true)
                Log.d("NODE5_TAG", "Node5 true")
            }else{
                Variables.nodes += ("Node5" to false)
                Log.d("NODE5_TAG", "Node5 false")
            }
        }

        "c building" ->{
            node10(qiContext)
            if (Variables.nodes["Node11"] == true) {
                Variables.nodes += ("Node5" to true)
                Log.d("NODE5_TAG", "Node5 true")
            }else{
                Variables.nodes += ("Node5" to false)
                Log.d("NODE5_TAG", "Node5 false")
            }
        }
    }

}