package chapter3

import io.reactivex.Observable
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("gpgudan in : ")
    val dan = scanner.nextInt()

//    val source = Observable.range(1, 9)˚
//    source.subscribe {
//        println(dan * it)
//    }
    val source = Observable.just(dan)
        .flatMap {
            Observable.range(1, 9)
                .map { dan * it }
        }
    source.subscribe {
        println(it)
    }
}
