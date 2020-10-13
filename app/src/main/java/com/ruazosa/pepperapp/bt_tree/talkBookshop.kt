package com.ruazosa.pepperapp.bt_tree

import android.content.Context
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

fun talkingBookshop(qiContext: QiContext) {

    Variables.saying += ("Bookshop" to false)
    Log.d("BOOKSHOP_STARTED", "sayBookshop block started")
    val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

    var say: Say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("The bookshop is near the main entrance. Just follow me. "))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()

    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("This is the place where all our students buy their books, notebooks and all the stuff for college."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()

    say.run()

    say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Sometimes they just stop by to get some ice cream or a chocolate for a snack."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()

    say.run()

    Variables.saying += ("Bookshop" to true)
    Variables.word = ""

}