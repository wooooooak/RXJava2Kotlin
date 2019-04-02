package chapter4

import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun main() {
    // 0.5초 뒤에 실행되는 코드이기 때문에 비동기이다.
    // 0.5초 뒤에 받아온 값으로 무언가를 처리(여기서는 println)해주기란 복잡하고 어려운 일이지만,
    // Rx를 사용하면 편하다
    val source = Observable.timer(500L, TimeUnit.MILLISECONDS)
        .map { SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Date()) }
    source.subscribe { println(it) }
    Thread.sleep(600)
}