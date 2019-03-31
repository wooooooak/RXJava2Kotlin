package chapter2

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.subjects.AsyncSubject

fun main() {
    val subject = AsyncSubject.create<String>() // AsyncSubject 객체인 subject는 정적 팩토리 함수인 create()로 생성함.
    subject.subscribe{ println("Subscribe #1 =>$it")}
    subject.onNext("1")
    subject.onNext("3")
    subject.subscribe{ println("Subscribe #2 =>$it")}
    subject.subscribe({
        println(it)
    },{
        println(it)
    })
    subject.onNext("5")
    subject.onComplete()
}