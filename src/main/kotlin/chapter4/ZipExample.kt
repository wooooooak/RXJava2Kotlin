package chapter4

import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.toObservable
import java.util.*

fun main() {
    val shapes = arrayOf("BALL", "PENTAGON", "STAR")
    val coloredTriangles = arrayOf("2-T", "6-T", "4-T")

    val source = Observables.zip(
        shapes.toObservable().map { getSuffix(it) },
        coloredTriangles.toObservable().map { it+"gg" }
    ) { suffix, color -> color + suffix }

    source.subscribe{println(it)}
}

fun getSuffix(shape: String): String {
    if (shape == "PENTAGON") {
        return "-P"
    }
    if (shape == "STAR") {
        return "-S"
    }
    return ""
}
