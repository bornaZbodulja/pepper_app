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

fun sayEnd(qiContext: QiContext){

    GlobalScope.launch {
        Variables.saying += ("End" to false)
        Log.d("END_TAG", "sayEnd block started")

        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

        val say: Say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("It was a pleasure to be your host. Hope to see you soon again. Goodbye"))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        Thread.sleep(2000)
        Variables.saying += ("End" to true)

    }

}