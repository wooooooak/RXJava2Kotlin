package chapter5

import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers

fun main() {
    val orgs = arrayOf("1", "3", "5")
    orgs.toObservable().doOnNext { println(it) }
        .map { "<< $it >>" }
        .subscribeOn(Schedulers.newThread())
        .subscribe { println(it) }

    Thread.sleep(500)

    orgs.toObservable().doOnNext { println("Original data: $it") }
        .map { "## $it ##" }
        .subscribeOn(Schedulers.newThread())
        .subscribe { println(it) }
    Thread.sleep(500)
}