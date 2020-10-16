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

fun talkCBuilding(qiContext: QiContext) {

    Variables.saying += ("CBuilding" to false)
    Log.d("CBUILDING_STARTED", "sayCBuilding block started")
    val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

    var say: Say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("C building is the highest building at the Faculty."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()


    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("6 out of 12 Faculty departments are settled there. One of them is the Department of Control and Computer Engineering."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("There are students and professors who work together with robots just like myself. Our professors have their offices on the 9th and 11th floor."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Students who do their projects have the laboratories on the ground floor."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("My ACROSS laboratory is close to the elevators to the right."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Here you need to choose which floor you want before you get in and wait for elevators A,B or C to get you. "))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()


    Variables.saying += ("CBuilding" to true)
    Variables.word = ""
    Variables.tabletInput = false


}