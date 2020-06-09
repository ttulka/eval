package com.ttulka.eval.kotlin

fun main(args: Array<String>) {
    println("Hello, World!")

//    fun parseInt(str: String): Int? {
//        return null
//    }
//
//    val x = parseInt("arg1")
//    val y = parseInt("arg2")
//
//    println(x * y)
//    if (x != null && y != null) {
//        println(x * y)  // ok here
//    }

//    val myChar = 'a'
//    val myChar2 = 97.toChar()
//
//    println("$myChar, $myChar2, ${myChar.toInt()}")

//    val something: Int = 1
//    val nothing: Nothing = Nothing()
//    println("${something is Any} Any")
//    println("${something is Nothing} Nothing")
//    println("${nothing is Any} Any")
//    println("${nothing is Nothing} Nothing")

//    val myIntArray2 = arrayOf(1,2,3).toIntArray()
//    println(myIntArray2 is IntArray)
//
//    val myIntArray3 = myIntArray2.toTypedArray()
//    println(myIntArray3 is Array<Int>)  // true

//    class InitOrderDemo(name: String) {
//        val firstProperty = "First property: $name".also(::println)  // 1
//
//        init {
//            println("First initializer block that prints ${name}")   // 2
//        }
//
//        val secondProperty = "Second property: ${name.length}".also(::println) // 3
//
//        init {
//            println("Second initializer block that prints ${name.length}")  // 4
//        }
//    }
//    InitOrderDemo("ahoj")

//    class Constructors {
//
//        constructor(i: Int) {
//            println("Constructor")
//        }
//        init {
//            println("Init block")
//        }
//    }
//    Constructors(0)

//    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
//        val tmp = this[index1] // 'this' corresponds to the list
//        this[index1] = this[index2]
//        this[index2] = tmp
//    }
//    val list = mutableListOf(1, 2, 3)
//    list.swap(0, 2)

//    val numbers = listOf("one", "two", "three", "four")
//
//    val filteredIdx = numbers.filterIndexed { index, s -> index != 0 && s.length < 5  }
//    println(filteredIdx)

//    val numbers = listOf(1, 2, 3)
//
//    val plusList = numbers + 4
//    val minusList1 = numbers - listOf(1, 3)
//    val minusList2 = numbers - 3
//
//    println(plusList)
//    println(minusList1)
//    println(minusList2)

//    val numbers = listOf("one", "two", "three", "four", "five")
//
//    println(numbers.groupBy { it.toUpperCase() })
//    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))

//    val numbers = listOf(1, 2, 3, 4, 5, 6)
//    println(numbers.slice(1..3))
//    println(numbers.slice(0..4 step 2))
//    println(numbers.slice(setOf(3, 5, 0)))

//    val numbers = listOf(1, 2, 3, 4, 5, 6)
//    println(numbers.take(3))
//    println(numbers.takeLast(3))
//    println(numbers.drop(1))
//    println(numbers.dropLast(5))

//    val numbers = (1..5).toList()
//    println(numbers.chunked(2))
//    println(numbers.windowed(2))

    println("-------------------")

    val numbers = listOf("one", "two", "three")

    println(numbers.elementAt(2))

    println(numbers.elementAtOrNull(9))
    println(numbers.elementAtOrElse(9) {
        index -> "value for $index undefined"})

    println("-------------------")

    println(numbers.first())
    println(numbers.last())
    println(numbers.first { it.startsWith("t") })
    println(numbers.last { it.startsWith("t") })

    println(numbers.firstOrNull { it.length > 9 })

    println("-------------------")

    println(numbers.find { it.startsWith("t") })
    println(numbers.findLast { it.startsWith("t") })

    println(numbers.random())

    println("-------------------")

    println(numbers.contains("four"))
    println("zero" in numbers)

    println(numbers.containsAll(listOf("four", "two")))
    println(numbers.containsAll(listOf("one", "zero")))

    println(numbers.isEmpty())
    println(numbers.isNotEmpty())
}