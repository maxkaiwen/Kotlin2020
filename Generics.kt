package kotlinpractice

fun main(){
val box: Box<Int> = Box<Int>(1)
   val box2=Box(4)


    val ints:Array<Int> = arrayOf(1,2,3)
    val any = Array<Any>(3){" "}
    copy(ints, any)
}
class Box<T>(t: T){
    var value=t
}
interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs

}
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) //

    val y: Comparable<Double> = x // OK!
}
fun copy(from: Array<Any>, to: Array<Any>){
    assert(from.size==to.size)
    for(i in from.indices)
        to[i]=from[i]
}

