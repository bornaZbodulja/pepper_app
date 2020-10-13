package com.ruazosa.pepperapp.bt_tree

import android.util.Log
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.conversation.BodyLanguageOption
import com.aldebaran.qi.sdk.`object`.conversation.Phrase
import com.aldebaran.qi.sdk.`object`.conversation.Say
import com.aldebaran.qi.sdk.`object`.locale.Language
import com.aldebaran.qi.sdk.`object`.locale.Locale
import com.aldebaran.qi.sdk.`object`.locale.Region
import com.aldebaran.qi.sdk.builder.SayBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun sayIntroduction(qiContext: QiContext){

    GlobalScope.launch {
        Variables.saying += ("Introduction" to false)
        Log.d("INTRODUCTION_TAG", "introduction block started")

        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

        var say: Say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("Hello! Welcome to the Faculty of Electrical Engineering and Computing."))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        Thread.sleep(500)

        say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("My name is Pepper, and I will be your host today. Please stand still."))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        Variables.saying += ("Introduction" to true)
    }
}