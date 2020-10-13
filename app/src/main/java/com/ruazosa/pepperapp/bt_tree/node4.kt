package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.conversation.BodyLanguageOption
import com.aldebaran.qi.sdk.`object`.conversation.Phrase
import com.aldebaran.qi.sdk.`object`.conversation.Say
import com.aldebaran.qi.sdk.`object`.locale.Language
import com.aldebaran.qi.sdk.`object`.locale.Locale
import com.aldebaran.qi.sdk.`object`.locale.Region
import com.aldebaran.qi.sdk.builder.ListenBuilder
import com.aldebaran.qi.sdk.builder.PhraseSetBuilder
import com.aldebaran.qi.sdk.builder.SayBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun node4(qiContext: QiContext){
    GlobalScope.launch {
        Log.d("NODE4_TAG", "Node4 started")
        node7(qiContext)
        if(Variables.nodes["Node7"] == true){
            Variables.nodes += ("Node4" to true)
            Log.d("NODE4_TAG", "Node4 true")
        }else{
            node8(qiContext)
            if(Variables.nodes["Node8"] == true){
                Variables.nodes += ("Node4" to true)
                Log.d("NODE4_TAG", "Node4 true")
            }else{
                Variables.nodes += ("Node4" to false)
                Log.d("NODE4_TAG", "Node4 false")
            }
        }
    }
}