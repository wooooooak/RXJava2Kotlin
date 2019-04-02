package chapter4

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    val source = Observable.intervalRange(1, 5, 100L, 100L, TimeUnit.MILLISECONDS)
    source.subscribe{println(it)}
    Thread.sleep(1000)
}

fun myIntervalRange() {
    val source = Observable.interval(100L, TimeUnit.MILLISECONDS)
        .map { it + 1 }
        .take(5)

    source.subscribe{ println(it) }
    Thread.sleep(1000)
}