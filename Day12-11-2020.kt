package kotlinpractice
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


fun main(args: Array<String>) {
    /* val p1 = Person3()
    Person4.callMe()
    // calling callMe() method using object p1
    p1.callMe()
    Person5.callMe()
    val e = Example()
    println(e.p)
    e.p="hi"
    println(e.p)

    */
 /*   val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }


        println(lazyValue)
        println(lazyValue)
    val user = User1()
    user.name = "first"
    user.name = "second"
*/
  /*  val userTest=UserTest(mapOf("name" to "John Doe", "age" to 25))
    println(userTest.name)
    println(userTest.age)*/
   /* val ingredients: ArrayList<String> by lazy {IceCreamIngredients.loadIngredients()}
    println(ingredients)
    IceCream(ingredients)
    println(ingredients)
    */
    val newCar=Car("Red","Suzuki")
    newCar.reFuel()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.drive()
    newCar.reFuel()
    newCar.drive()
    newCar.drive()

}


class Person3 {
    fun callMe() = println("I'm called.")
}



class Person4 {
    companion object Test {
        fun callMe() = println("I'm called P4.")
    }

}
class Person5 {

    companion object {
        fun callMe() = println("P5 Called")
    }
}
class Example {
    var p: String by Delegate()
}


class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}
class User1 {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }
}
/*class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate)
{
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt

}
var MyClass.extDelegated: Int by ::topLevelInt
*/

class UserTest(val map: Map<String,Any?>)
{
    val name: String by map
    val age: Int by map
}
//rewrite the IceCream class below to use default values and lazy initialization
//1. use default value for the name property
//2. Lazily init the ingredients list
class IceCream (val ingredients: ArrayList<String>,val name : String="Vanilla"  )
{



}
class IceCreamIngredients(){
companion object{
    fun loadIngredients():ArrayList<String>{
        println("Loading ingredients")
        return arrayListOf("Vanilla","Chocolate","Mint","Strawberry")

    }
}
}
/*
write car class dive into inner working of car class and rewrite FuelTank class below with delegated property observer functionality
 */

//1. Add a lowFuel property of Boolean type to the class
//2. Flip the lowFuel boolean when the level drops below 10%
//3. Ensure that when the tank fills back up the lowFuel warning will turn off
//4. Add a FuelTank property to Car and fill the tank . then drive around for a while
class Car(val color:String, val make:String){
    var tank:FuelTank= FuelTank(10.0)
    init{println("$color $make Car made")}
    fun drive(){
        if(tank.level>0){



        println("Driving")
        tank.level--
        println("Fuel tank is ${tank.level}")
        if(tank.lowFuel){
            println("Fuel low")
        }
        }
        if(tank.level<=0) {
            println("No fuel")
        }
    }
    fun reFuel(){
        tank.level=tank.max
        tank.lowFuel=false
        println("Refueled to $tank.max")
    }
}

class FuelTank(max:Double){
    var lowFuel=false
    var max=max
    var level:Double by Delegates.observable(0.0){
        prop, old, new->println("$old->$new")
        if(level<=max/10){
             lowFuel=true
            //println("Fuel Low")
         if(level>max/10)
             lowFuel=false


        }
    }

}