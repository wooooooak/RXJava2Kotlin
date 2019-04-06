package chapter4

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.toObservable
import io.reactivex.rxkotlin.zipWith

import java.util.concurrent.TimeUnit


fun main() {
    val data1 = arrayOf("6","7","4","2")
    val data2 = arrayOf("DIAMOND", "STAR", "PENDTAGON")

    val source = Observables.combineLatest(
        data1.toObservable().zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS)) {
                shape, _ ->
            "color is $shape "
        },
        data2.toObservable().zipWith(Observable.interval(150L, 200L, TimeUnit.MILLISECONDS)) {
            shape, _ -> "suffix is $shape "
        }
    ) {
        v1, v2 -> v1 + v2
    }

    source.subscribe{
        println(it)
    }

    Thread.sleep(1000)
}