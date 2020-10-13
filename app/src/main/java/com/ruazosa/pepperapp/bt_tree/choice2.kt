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

fun sayChoice2(qiContext: QiContext) {

    Variables.saying += ("Choice2" to false)
    Log.d("CHOICE2_TAG", "sayChoice2 block started")

    val locale = Locale(Language.ENGLISH, Region.UNITED_STATES)

    var say: Say = SayBuilder.with(qiContext)
        .withPhrase(Phrase("Please tell me again where do you want me to take you."))
        .withBodyLanguageOption(BodyLanguageOption.NEUTRAL)
        .withLocale(locale)
        .build()
    say.run()

    Thread.sleep(300)

    Variables.saying += ("Choice2" to true)


}