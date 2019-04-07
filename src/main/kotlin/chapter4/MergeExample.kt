package chapter4

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable
import java.sql.Time
import java.util.concurrent.TimeUnit

fun main() {
    val data1 = arrayOf("1", "3")
    val data2 = arrayOf("2", "4", "6")

    val source1 = Observable.interval(0L, 100L, TimeUnit.MILLISECONDS)
        .map { it.toInt() }
        .map { data1[it] }
        .take(data1.size.toLong())

    val source2 = Observable.interval(50L, TimeUnit.MILLISECONDS)
        .map { it.toInt() }
        .map { data2[it] }
        .take(data2.size.toLong())

    val source = Observable.merge(source1, source2)
    source.subscribe{println(it)}
    Thread.sleep(1000)
}