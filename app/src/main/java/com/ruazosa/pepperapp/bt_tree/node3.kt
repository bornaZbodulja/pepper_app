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
import android.os.Handler;

class Listen4(qiContext: QiContext) {
    val qiContext = qiContext

    fun Speak_Process() {
        Log.d("NODE3_TAG", "node3 block started")
        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

        while (true) {
            Thread.sleep(3000)
            Log.d("NODE3_TAG", Variables.word)
            if (Variables.word.toLowerCase() == "bookshop") {
                Log.d("NODE3_TAG", "bookshop recognised")
                break
            } else if (Variables.word.toLowerCase() == "c building" || Variables.word.toLowerCase() == "elevators") {
                Log.d("NODE3_TAG", "c building recognised")
                break
            } else if (Variables.word.toLowerCase() == "tesla") {
                Log.d("NODE3_TAG", "tesla recognised")
                break
            } else {
                val say: Say = SayBuilder.with(qiContext)
                    .withPhrase(Phrase("Did not get the word, please try again."))
                    .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
                    .withLocale(locale)
                    .build()
                say.run()
            }
        }
        node5(qiContext)
        if(Variables.nodes["Node5"] == false){
            Variables.nodes += ("Node3" to false)
            Log.d("NODE3_TAG", "Node3 false")
        }else{
            node6(qiContext)
            if(Variables.nodes["Node6"] == false){
                Variables.nodes += ("Node3" to false)
                Log.d("NODE3_TAG", "Node3 false")
            }else{
                Variables.nodes += ("Node3" to true)
                Log.d("NODE3_TAG", "Node3 true")
            }

        }
    }

    fun Listening() {
        Speak_Process()
        Thread.sleep(5000)
    }
}

fun node3(qiContext: QiContext) {
    val new = Listen4(qiContext)
    new.Listening()
}