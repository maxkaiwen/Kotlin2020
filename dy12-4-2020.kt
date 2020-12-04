package kotlinpractice



fun main()
{
  //  var em =Employee()
    //em.insertValues("Max", 25, 'M', 15243.00)
   /* val p1=Person("Max",25)
    val p2=Person("John",23)
    val p3=Person("Yu",35)
    val a1= arrayOf(p2,p3)

    print(memberOf(p1,a1))
    */

    val u1=User("Max")
    val u2=User("Lee")
    val u3=User("Boris")
    val al1=arrayListOf(u1,u2,u3)
    val Titanic=MovieList("Titanic",al1)
    Titanic.printUsers()
    val u4=User("joe")
    Titanic.addUser(u4)
    Titanic.removeUser(u1)
    Titanic.printUsers()


   /* Create jane and john users and have them create and share lists.
   Have both jane and john modify the same list and calll print from both users.
   Are all the changes refcted ? observe that
    */
    val u5=User("Jane")
    val u6=User("John")
    u5.addMovie(Titanic)
    println()
    Titanic.printUsers()
    println()
    u5.printMovies()
    u6.addMovie(Titanic)
    Titanic.printUsers()
}

/*
Write a function memberOf(person : Person, group :[Person] -> Bool that will return true if person can be found inside group and false if it is not.
 */
fun memberOf(person : Person, group :Array<Person>) :Boolean
{
    if (group.contains(person))
        return true

    return false

}
class Person(name:String,age:Int){
    var name: String=name
    var age:Int=age;

}

/*
Create a User class and a MovieList class that maintains lists of users.

 */
class User(name:String){
    var name: String=name
    //var age:Int=age;
    var listOfMovies=ArrayList<MovieList>()

    fun addMovie(movie:MovieList)
    {
        listOfMovies.add(movie)
        movie.addUser(this)
    }
    fun removeMovie(movie:MovieList)
    {
        listOfMovies.remove(movie)
        movie.removeUser(this)
    }
    fun  printMovies(){
        for(movie in listOfMovies){
            println (movie.title)
        }

    }
}
class MovieList(title:String,listIn:ArrayList<User>)
{
    var title: String=title
     var list=listIn
    fun addUser(user:User)
    {list.add(user)

    }
    fun removeUser(user:User)
    {
        list.remove(user)
    }
     fun  printUsers(){
         for(user in list){
             println (user.name)
         }

     }



}

/*
 Create jane and john users and have them create and share lists.
  Have both jane and john modify the same list and calll print from both users.
   Are all the changes refcted ? observe that
 */
/*
Create a named object that lets you check whether a given Int value is above a threshold.
 Name the object Threshold and add a method isAboveThreshold(value : Int )
 */
object Threshold{
    val threshold:Int=10
    fun isAboveThreshold(value:Int)
    {
        if(threshold>value)
        println("false")
        println("true")
    }
}



/*
Create an anonumous object that implements the following interface:

interface ThresholdChecker { val lower : Int

val upper : Int

fun isLit(value : Int ): Boolean

fun tooQuite(value : Int  ): Boolean

}
 */
interface ThresholdChecker
{ val lower : Int

    val upper : Int

    fun isLit(value : Int ): Boolean

    fun tooQuite(value : Int  ): Boolean

}
object ThresholdObj:ThresholdChecker
{
    override val lower: Int
        get() = lower
    override val upper: Int
        get() = upper

    override fun isLit(value: Int): Boolean {
        if(upper<value&&value>lower)
        return true
        return false
    }

    override fun tooQuite(value: Int): Boolean {
        if(upper>value&&value<lower)
            return true
        return false
    }

}

class Employee {
    // properties
    var name: String = ""
    var age: Int = 0
    var gender: Char = 'M'
    var salary: Double = 0.toDouble()
    //member functions
    fun name(){

    }
    fun age() {

    }
    fun salary(){

    }
    fun insertValues(n: String, a: Int, g: Char, s: Double) {
        name = n
        age = a
        gender = g
        salary = s
        println("Name of the employee: $name")
        println("Age of the employee: $age")
        println("Gender: $gender")
        println("Salary of the employee: $salary")
    }
}