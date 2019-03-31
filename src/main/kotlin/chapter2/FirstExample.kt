package chapter2

import io.reactivex.Observable

class FirstExample {
    fun emit() {
        Observable.just("Hello", "Rx Kotlin !!").subscribe {
            println(it)
        }
    }
}