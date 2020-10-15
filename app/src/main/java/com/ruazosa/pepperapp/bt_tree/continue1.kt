package com.ruazosa.pepperapp.bt_tree

import android.os.Handler
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
import com.aldebaran.qi.sdk.util.PhraseSetUtil

class Listen3(qiContext: QiContext) {
    val qiContext = qiContext

    fun Speak_Process() {
        Log.d("CONTINUE1_TAG", "continue block started")
        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)
        Variables.listening += ("Continue" to false)

        val say: Say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("Is there anywhere else you would like me to take you?"))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        val phraseSetNo = PhraseSetBuilder.with(qiContext)
            .withTexts("nope", "no")
            .build()

        val phraseSetYes = PhraseSetBuilder.with(qiContext)
            .withTexts("yes", "yeah")
            .build()

        while (true) {
            val listen = ListenBuilder.with(qiContext)
                .withPhraseSets(phraseSetNo, phraseSetYes)
                .build()

            val listenResult = listen.run()

            val matchedPhraseSet = listenResult.matchedPhraseSet

            if (PhraseSetUtil.equals(matchedPhraseSet, phraseSetYes)) {
                Variables.listening += ("Continue" to true)
                break
            } else if (PhraseSetUtil.equals(matchedPhraseSet, phraseSetNo)) {
                Variables.listening += ("Continue" to false)
                break
            } else {
                val sayy: Say = SayBuilder.with(qiContext)
                    .withPhrase(Phrase("Did not get the word, say yes or no again"))
                    .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
                    .withLocale(locale)
                    .build()
                sayy.run()
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