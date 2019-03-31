import io.reactivex.Observable

object FlatMapExam {
    fun flatMapLambda() {
        //Observable안에 Observable을 넣는다는 것이 직관적이지는 않음
        val balls = arrayOf("1", "2", "3")
        val source = Observable.fromArray(*balls)
            .flatMap { ball -> Observable.just("$ball<>", "$ball<>") }
        source.subscribe { println(it) }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        flatMapLambda()
    }
}
