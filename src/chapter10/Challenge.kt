package chapter10

import java.io.File

val menuList2 = File("data/tavern-menu-items.txt").readText().split("\r\n")

fun main(args: Array<String>) {
    var dotCount = 0
    menuList2.forEach {
        if(dotCount < it.length)
            dotCount = it.length
    }

    var list = mutableListOf<String>()

    for (menuItem in menuList2) {
        var (_, name, price) = menuItem.split(",")
        val len = (name + price).length

        val count = dotCount - len
        for (i in 0 until count) {
            name += "."
        }
    }

    println("*** Welcome to Taernyl's Folly")
    for(item in list) {
        println(item)
    }
}