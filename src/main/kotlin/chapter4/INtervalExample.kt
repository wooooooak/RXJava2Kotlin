package chapter4

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    val source = Observable.interval(100L, TimeUnit.MICROSECONDS)
        .map { (it + 1) * 100 }
        .take(5)
    source.subscribe { println("ddd") }
    Thread.sleep(1000) // 현재 쓰레드를 1초동안 멈춰야지만, 백그라운드에서 실행되는 로그들을 다 볼 수 있다.
}