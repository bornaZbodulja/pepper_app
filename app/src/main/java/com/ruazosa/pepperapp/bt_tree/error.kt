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

fun sayError(qiContext: QiContext){
    GlobalScope.launch {
        Variables.saying += ("Error" to false)
        Log.d("ERROR_TAG", "sayError block started")

        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

        var say: Say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("Oops, it looks like an error happened somewhere in the behavior."))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        Thread.sleep(400)

        say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("Try to look at your computer and find the problem"))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        Variables.saying += ("Error" to true)
    }
}