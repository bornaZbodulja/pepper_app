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

fun saySeeYou(qiContext: QiContext) {
    Variables.saying += ("SeeYou" to false)
    Log.d("SEEYOU_TAG", "saySeeYou block started")

    val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

    val say: Say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Hi ${Variables.name}, it is nice to see you again at the Faculty."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    Variables.saying += ("SeeYou" to true)
    Log.d("SEEYOU_TAG", "SeeYou block executed")

}