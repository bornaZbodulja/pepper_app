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

fun sayChoice1(qiContext: QiContext){

    GlobalScope.launch {
        Variables.saying += ("Choice1" to false)
        Log.d("CHOICE1_TAG", "sayChoice1 block started")

        val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

        var say: Say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("Please tell me where do you want me to take you."))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        Thread.sleep(500)

        say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("You can choose from the Tesla monument, bookshop, or C building elevators."))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        Thread.sleep(300)

        say = SayBuilder.with(qiContext)
            .withPhrase(Phrase("Just pick a location on my tablet or simply tell me."))
            .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
            .withLocale(locale)
            .build()
        say.run()

        Variables.saying += ("Choice1" to true)
    }
}