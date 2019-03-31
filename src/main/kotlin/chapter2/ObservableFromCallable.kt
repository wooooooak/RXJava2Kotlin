package chapter2

import io.reactivex.Observable
import java.util.concurrent.Callable

fun main() {
    val callable = Callable {
        Thread.sleep(1000)
        "Hello Callable"
    }

    val source = Observable.fromCallable(callable)
    source.subscribe { println(it) }
    source.subscribe { println(it) }
    source.subscribe { println(it) }

}