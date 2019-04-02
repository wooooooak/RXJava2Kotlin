package chapter4

import io.reactivex.Observable

fun main() {
    Observable.range(1,10).filter { it % 2 == 0 }.subscribe{println(it)}
}