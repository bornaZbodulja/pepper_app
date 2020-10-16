package com.ruazosa.pepperapp.bt_tree

import android.os.Handler
import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.conversation.BodyLanguageOption
import com.aldebaran.qi.sdk.`object`.conversation.Phrase
import com.aldebaran.qi.sdk.`object`.conversation.PhraseSet
import com.aldebaran.qi.sdk.`object`.conversation.Say
import com.aldebaran.qi.sdk.`object`.locale.Language
import com.aldebaran.qi.sdk.`object`.locale.Locale
import com.aldebaran.qi.sdk.`object`.locale.Region
import com.aldebaran.qi.sdk.builder.ListenBuilder
import com.aldebaran.qi.sdk.builder.PhraseSetBuilder
import com.aldebaran.qi.sdk.builder.SayBuilder
import com.aldebaran.qi.sdk.util.PhraseSetUtil

class Listen1(qiContext: QiContext) {

    private val qiContext = qiContext

    fun Speak_Process() {
        Log.d("BOOKSHOPCONF", "bookshop block started")
        Variables.listening += ("BookshopConf" to false)
        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

        if (Variables.tabletInput) {
            Variables.listening += ("BookshopConf" to true)
        } else {

            val say: Say = SayBuilder.with(qiContext)
                .withPhrase(Phrase("Did you say bookshop?"))
                .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
                .withLocale(locale)
                .build()
            say.run()

            while (true) {

                val phraseSetNo = PhraseSetBuilder.with(qiContext)
                    .withTexts("nope", "no")
                    .build()

                val phraseSetYes = PhraseSetBuilder.with(qiContext)
                    .withTexts("yes", "yeah")
                    .build()

                val listen = ListenBuilder.with(qiContext)
                    .withPhraseSets(phraseSetNo, phraseSetYes)
                    .build()

                val listenResult = listen.run()

                val matchedPhraseSet = listenResult.matchedPhraseSet

                if (PhraseSetUtil.equals(matchedPhraseSet, phraseSetYes)) {
                    Variables.listening += ("BookshopConf" to true)
                    break
                } else if (PhraseSetUtil.equals(matchedPhraseSet, phraseSetNo)) {
                    Variables.listening += ("BookshopConf" to false)
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
    }

    fun Listening() {

        Speak_Process()
        Thread.sleep(1000)

    }
}

fun bookshopConf(qiContext: QiContext) {
    val new = Listen1(qiContext)
    new.Listening()
}