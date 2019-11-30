package chapter2

fun main(args: Array<String>) {
    var string = "string"
    var char = 'c'
    var boolean = true
    var int = 5
    var double = 5.5
    var float = 5.5f

    var list0 = listOf(1..5)
    var list1 = arrayListOf(1..5)
    var list2 = List(5, {i-> i})
    var list3 = (1..5).toList()

    var set0 = setOf(1, 1, 3, 2)
    var set1 = hashSetOf(1, 1, 3, 2)
    var set2 = linkedSetOf(1, 1, 3, 2)
    var set3 = sortedSetOf(1, 1, 3, 2)
    var set4 = (1..5).toSet()
    var set5 = (1..5).toHashSet()

    var map0 = mapOf("one" to 1, "two" to 2)
    var map1 = mapOf(Pair("one",1), Pair("two",2))
    var map2 = hashMapOf(Pair("one",1), Pair("two",2))
    var map3 = linkedMapOf(Pair("one",1), Pair("two",2))
    var map4 = sortedMapOf(Pair("one",1), Pair("two",2))
}