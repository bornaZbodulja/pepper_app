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
import com.aldebaran.qi.sdk.util.PhraseSetUtil

class Listen4(qiContext: QiContext) {
    val qiContext = qiContext

    fun Speak_Process() {
        Log.d("NODE3_TAG", "node3 block started")
        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

        val phraseSetBookshop = PhraseSetBuilder.with(qiContext)
            .withTexts("bookshop")
            .build()

        val phraseSetTesla = PhraseSetBuilder.with(qiContext)
            .withTexts("tesla", "tesla monument", "monument")
            .build()

        val phraseSetCBuilding = PhraseSetBuilder.with(qiContext)
            .withTexts("c building", "elevators")
            .build()

        while (true) {

            val listen = ListenBuilder.with(qiContext)
                .withPhraseSets(phraseSetBookshop, phraseSetTesla, phraseSetCBuilding)
                .build()

            val listenResult = listen.run()

            val matchedPhraseSet = listenResult.matchedPhraseSet
            // Log.d("NODE3_TAG", Variables.word)
            if (Variables.word.toLowerCase() == "bookshop" || PhraseSetUtil.equals(
                    matchedPhraseSet,
                    phraseSetBookshop
                )
            ) {
                Log.d("NODE3_TAG", "bookshop recognised")
                Variables.word = "bookshop"
                break
            } else if (Variables.word.toLowerCase() == "c building" || PhraseSetUtil.equals(
                    matchedPhraseSet,
                    phraseSetCBuilding
                )
            ) {
                Log.d("NODE3_TAG", "c building recognised")
                Variables.word = "c building"
                break
            } else if (Variables.word.toLowerCase() == "tesla" || PhraseSetUtil.equals(
                    matchedPhraseSet,
                    phraseSetTesla
                )
            ) {
                Log.d("NODE3_TAG", "tesla recognised")
                Variables.word = "tesla"
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
        if (Variables.nodes["Node5"] == false) {
            Variables.nodes += ("Node3" to false)
            Log.d("NODE3_TAG", "Node3 false")
        } else {
            node6(qiContext)
            if (Variables.nodes["Node6"] == false) {
                Variables.nodes += ("Node3" to false)
                Log.d("NODE3_TAG", "Node3 false")
            } else {
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