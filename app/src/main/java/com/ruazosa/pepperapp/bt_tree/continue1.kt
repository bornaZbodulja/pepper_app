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

class Listen3(qiContext: QiContext) {
    val qiContext = qiContext

    fun Speak_Process() {
        Log.d("CONTINUE1_TAG", "continue block started")
        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)
        Variables.listening += ("Continue" to false)

        var say: Say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("Is there anywhere else you would like me to take you?"))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        val phraseSet = PhraseSetBuilder.with(qiContext)
            .withTexts("yes", "no")
            .build()

        while (true) {
            val listen = ListenBuilder.with(qiContext)
                .withPhraseSet(phraseSet)
                .build()

            val listenResult = listen.run()

            Thread.sleep(3000)

            when (listenResult.heardPhrase.text.toLowerCase()) {
                "yes" -> {
                    Variables.listening += ("Continue" to true)
                }
                "no" -> {
                    Variables.listening += ("Continue" to false)
                }
                else -> {
                    val say: Say = SayBuilder.with(qiContext)
                        .withPhrase(Phrase("Please repeat, did not get the word"))
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

fun continue1(qiContext: QiContext) {
    val new = Listen3(qiContext)
    new.Listening()
}