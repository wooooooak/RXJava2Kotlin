package chapter3

import io.reactivex.Observable

fun main() {
    val balls = Array(3) {
        (it+1).toString()
    }

    val source : Observable<String> = Observable.fromArray(*balls).flatMap {
        Observable.just("$it diamonds", "$it diamonds")
    }

    source.subscribe { println(it) }
}