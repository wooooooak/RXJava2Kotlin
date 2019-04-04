package chapter4

import io.reactivex.Observable

fun main() {
    val objs = arrayOf("6", "4", "2-T", "2", "6-T", "4-T")
    val source = Observable.fromArray(*objs).groupBy{
        getShape(it)
    }
    source.subscribe{ obj ->
        obj.filter { obj.key == "BALL" }.subscribe {
            println("GROUP: ${obj.key} `\t` Value: $it")
        }
    }
}

fun getShape(obj: String): String {
    if (obj.isEmpty()) return "NO_SHAPE"
    if (obj.endsWith("-O")) return "HEXAGON"
    if (obj.endsWith("-R")) return "OCTAGON"
    if (obj.endsWith("-T")) return "RECTANGLE"
    if (obj.endsWith("-D")) return "TRIANGLE"
    if (obj.endsWith("-D")) return "DIAMOND"
    return "BALL"
}