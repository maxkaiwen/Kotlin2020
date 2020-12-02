package kotlinpractice

import java.lang.NullPointerException


fun main() {
      //  fullName("Max", "Lee")

        // val nameFull = calculateFullName("Max", "Lee");
       // print(nameFull);


        //should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
     //   println(fibonacciRecursive(3))
    /*   var count=0;
        while(count<10){
            println(fibonacciRecursive(count))
            count++
        }*/
       // println(addSub(5, 7, ::add))
        //println(addSub(11, 3, ::sub))


        val myFavoriteSong : String? = "Overture"
        myFavoriteSong!!

        val myFavoriteSong2 : String?=null

        try
        {
            myFavoriteSong2!!

        }catch(e : NullPointerException){
            println("I don't have favorite song")
        }

       // println( myFavoriteSong.length)
      //   println( myFavoriteSong2?.length)

        println(myFavoriteSong2?:myFavoriteSong)
    }

    fun fullName(first: String, last: String) {
        print(first + " " + last)
    }

    fun calculateFullName(first: String, last: String): Pair<Int,String>{
    var name=first + " " + last
        val (x, y) = Pair(name.length, name)
        return Pair(x, y)
    }

fun fibonacciRecursive(x: Int): Int
{

    if(x===0||x===1){
        return x
    }
    return fibonacciRecursive(x-1)+fibonacciRecursive(x-2)
}
fun add(x: Int, y: Int) : Int {
    return x + y
}
fun sub(x: Int, y: Int) : Int {
    return x - y
}

fun addSub(x: Int, y: Int, p: (Int, Int) -> Int) : Int {
    return p(x,y)
}
/*
*
* Make a nullable String called myFavoriteSong.
* if you have a favorite song, set it to a string representing that song.
*  if you have more than one favorite song or no favorite, set the nullable to null
*
*
 */