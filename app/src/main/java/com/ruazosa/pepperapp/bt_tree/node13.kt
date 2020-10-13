package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node13(qiContext: QiContext){
    GlobalScope.launch {
        Log.d("NODE13_TAG", "Node13 started")
        bookshopConf(qiContext)
        if(Variables.listening["BookShopConf"] == false){
            Variables.nodes += ("Node13" to false)
            Log.d("NODE13_TAG", "Node13 false")
        }else{
            talkingBookshop(qiContext)
            if(Variables.saying["Bookshop"] == true){
                Variables.nodes += ("Node13" to true)
                Log.d("NODE13_TAG", "Node13 true")
            }else{
                Variables.nodes += ("Node13" to false)
                Log.d("NODE13_TAG", "Node13 false")
            }
        }
    }
}