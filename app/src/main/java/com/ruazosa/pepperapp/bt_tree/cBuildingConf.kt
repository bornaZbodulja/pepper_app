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

class Listen2(qiContext: QiContext) {

    private val qiContext = qiContext
    val vocabulary = Variables.vocabulary

    fun Speak_Process() {
        Log.d("CBUILDING_CONF", "cBuilding block started")
        Variables.listening += ("CBuildingConf" to false)
        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

        while (true) {

            val phraseSet = PhraseSetBuilder.with(qiContext)
                .withTexts("yes", "no")
                .build()

            val say: Say = SayBuilder.with(qiContext)
                .withPhrase(Phrase("Did you say C building elevators?"))
                .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
                .withLocale(locale)
                .build()
            say.run()

            val listen = ListenBuilder.with(qiContext)
                .withPhraseSet(phraseSet)
                .build()

            val listenResult = listen.run()

            Thread.sleep(3000)

            when (listenResult.heardPhrase.text.toLowerCase()) {
                "yes" -> {
                    Variables.listening += ("CBuildingConf" to true)
                }
                "no" -> {
                    Variables.listening += ("CBuildingConf" to false)
                }
                else -> {
                    val say: Say = SayBuilder.with(qiContext)
                        .withPhrase(Phrase("Did not get the word, say yes or no again"))
                        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
                        .withLocale(locale)
                        .build()
                    say.run()
                }
            }

        }
    }

    fun Listening() {
        Speak_Process()
        Thread.sleep(5000)

    }
}

fun cBuildingConf(qiContext: QiContext) {
    val new = Listen2(qiContext)
    new.Listening()
}