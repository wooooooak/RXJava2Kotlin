package chapter5

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    val orgs = arrayOf("1", "2", "3")

    val source = orgs.toObservable().zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS)) { a, b -> a }

    source.map { "<< $it >>" }
        .subscribeOn(Schedulers.computation())
        .subscribe { println(it) }

    source.map { "## $it ##" }
        .subscribeOn(Schedulers.computation())
        .subscribe { println(it) }
    Thread.sleep(1000)
}