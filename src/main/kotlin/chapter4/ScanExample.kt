package chapter4

import io.reactivex.Observable

fun main() {
    val balls = arrayOf("1", "3", "5")
    val source = Observable.fromArray(*balls)
        .scan{ ball1, ball2 -> "$ball2($ball1)" }
    source.subscribe{println(it)}
}