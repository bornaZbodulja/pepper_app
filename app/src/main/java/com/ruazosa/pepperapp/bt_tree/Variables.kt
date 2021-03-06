package com.ruazosa.pepperapp.bt_tree

object Variables {

    val IP = "192.168.1.107"
    val PORT = 9559
    val name = "Bosiljko"
    val language = "English"
    var word = ""
    var repeat = false
    var woken = false
    var recognised = false
    var learned = true
    var detected = false
    var invert = false
    var executed = false
    var navFail = false
    var tabletInput = false
    val vocabulary = setOf("yes", "no", "bookshop", "elevators", "c building",
    "tesla monument", "tesla", "monument")
    var saying = mapOf<String,Boolean>()
    var listening = mapOf<String, Boolean>()
    var nodes = mapOf<String, Boolean>()

}