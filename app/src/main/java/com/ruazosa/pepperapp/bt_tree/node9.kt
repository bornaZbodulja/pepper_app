package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node9(qiContext: QiContext){
    GlobalScope.launch {
        Log.d("NODE9_TAG", "Node9 started")
        bookshopCond()
        if (Variables.listening["BookShopCond"] == false){
            Variables.nodes += ("Node9" to false)
            Log.d("NODE9_TAG", "Node9 false")
        }else{
            node13(qiContext)
            if(Variables.nodes["Node13"] == false){
                Variables.nodes += ("Node9" to false)
                Log.d("NODE9_TAG", "Node9 false")
            }else{
                Variables.nodes += ("Node9" to true)
                Log.d("NODE9_TAG", "Node9 true")
            }
        }

    }
}