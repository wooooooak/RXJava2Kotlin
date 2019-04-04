package chapter4

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    val balls = arrayOf("1", "2", "3")
    val source = Observable.interval(100L, TimeUnit.MILLISECONDS)
        .map { it.toInt() }
        .map { balls[it] }
        .take(3)
        .switchMap { ball -> Observable.interval(200L, TimeUnit.MILLISECONDS).map{ ball + "!"}.take(2) }

    source.subscribe{println(it)}
    Thread.sleep(2000)
}
