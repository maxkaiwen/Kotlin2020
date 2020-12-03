package kotlinpractice

fun main()
{

val l1= listOf<Int>(1,4,2,7,12,2,3,6)
  //  print(l1.toString());
    //println(removeOne(2, l1))

    //println(remove(2, l1))
   // println(custReverse(l1))
   // val a1= arrayOf(1,4,5,6,3,4)
    //println(minMax(a1))
    val map= mapOf<String, Int>(Pair("d3",2),Pair("d2",1))
  // println(isInvertible(map))
    val map1 = mapOf<String, String>(Pair("d3","Max"),Pair("d1","Lee"))
    val map2=mapOf<String, String>(Pair("d3","Joe"),Pair("d5","Dylan"))
    println(mergeMaps(map1,map2))
}
/*
Write a function that removes the first occurrence of a given integer from a list of integers
 */

fun removeOne(item : Int, list: List<Int>): List<Int>
{   var count =0
    var ans= mutableListOf<Int>()

    var occur: Boolean =false
    while(count<list.size)
    {
        if(!occur)
        {
            if (list[count] != item) {
                ans.add(list[count])
            }else{
                occur=true
            }

        }else
        {
            ans.add(list[count])
        }
        count++
    }

return ans
}
/*
Write a function that removes all occurrences of a given integer from a list of integers. ( signature of function :
 */
fun remove(item : Int, list:List<Int> ) : List<Int >
{
    var count =0
    var ans= mutableListOf<Int>()

   // var occur: Boolean =false
    while(count<list.size)
    {

            if (list[count] != item) {
                ans.add(list[count])
            }


        count++
    }

    return ans
}

/*
Arrays and lists have a reverse() method that reverses all the element in place , that is, within the original array or list.
write function that does a similar thing, without using  reverse(),
and returns a new array with the elements of  the original array in reverse order
 */
fun custReverse(list:List<Int> ) : List<Int >
{ var count =0
    var size=list.size-1

    var ans= mutableListOf<Int>()
    while(count<list.size)
    {


            ans.add(list[size])


        size--
        count++
    }
    return ans
}
/*
Write  a funtion that calculates the min and max value in array of integers. calculate these values yourself don't use the methods min and max .
 return null if the given array is empty (
 */

fun minMax(numbers: Array<Int> ) : Pair<Int, Int>?
{
    var min: Int=numbers[0]
    var max: Int=numbers[0]
    if(numbers.isEmpty())
    {
        //val (x,y)= Pair<Int?,Int?>(null,null)
        return null
    }
    for (num in numbers)
    {
        if(num>max)max=num
        if(num<min)min=num
    }
    return Pair(min, max)

}

/*
Write a function that returns true if all of the values of a map are unique. Use a set to test uniqueness.
 */
fun isInvertible( map : Map<String, Int>):Boolean
{

   var count= map.values.toSet().size
    val mapNum=map.size
    if(count==mapNum)return true
    return false
}
/*
write a function that combines two maps into one . if a certain key appears in both maps, ignore the pair from the first maps.

 */

fun mergeMaps( map1 : Map<String, String >, map2 : Map<String, String>) : Map<String, String>
{
    var mapOut= map1.toMutableMap()
    mapOut.putAll(map2)
    return mapOut
}
//Lambdas

/*
create a constant list called nameList which contains some names as Strings.
Any names will do make sure there is more than three.
Now use fold to create a String which is concatenation of each name in the list
 */

