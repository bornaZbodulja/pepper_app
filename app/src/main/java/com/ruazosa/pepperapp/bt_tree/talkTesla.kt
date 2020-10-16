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

fun talkTesla(qiContext: QiContext) {

    Variables.saying += ("Tesla" to false)
    Log.d("TESLA_STARTED", "sayTelsa block started")
    val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

    var say: Say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("We will take a little walk to the other side of the Faculty. "))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("I believe you have already heard about Nikola Tesla."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("He is one of the greatest minds of the 20th century. He was born in Croatia in 1856, but most of his life he lived in the USA. "))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("In his early days he was an assistant to Thomas Alva Edison, but they got in a fight."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Edison wanted to do everything with DC current but Tesla thought that AC current is more efficient. His inventions changed the world. "))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Some of them are an electric motor and Tesla coil. He also found that energy can be transfered wirelessly."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Things like electric cars or wireless phone charging are getting much more popular in the last decade. "))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("The biggest electric car manufacturer is named after Nikola Tesla. It just shows the popularity that Tesla has in the world."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("This new Tesla truck caused a lot of talks amongst the people."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Here is the Tesla monument, hope you like it."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    Variables.saying += ("Tesla" to true)
    Variables.word = ""
    Variables.tabletInput = false


}