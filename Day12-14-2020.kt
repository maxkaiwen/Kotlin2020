package kotlinpractice

import java.time.DayOfWeek
import kotlin.math.roundToLong

fun main(){
/*val day=ADayofTheWeek.setDay("Tuesday")

print(day)*/

  var wallet1=Wallet(5.0,Wallet.AcceptedCurrency.US)
    var wallet2=Wallet(5.0,Wallet.AcceptedCurrency.AUS)
    //wallet1.addMoney(wallet2)
    //println(wallet1.amount)


}

/*
1)Add a companion function to aDayOfTheWeek which returns a nullable DayOfTheWeek bassed on a passed in index. Do the same for a passed-in string.

 */



     class ADayofTheWeek {

         enum class DayOfTheWeek {
             Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
         }

         companion object {
             val week= arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

         fun setDay(index: Int): DayOfTheWeek? {

             return DayOfTheWeek.valueOf(week[index])
         }
             fun setDay(index: String): DayOfTheWeek? {

                 return DayOfTheWeek.valueOf(index)
             }
     }
    }

/*
2)Create a way to add together the values of two AcceptedCurrency objects. think about following scenario:

- what should happen if both currencies are the same type

-what should happen if the currencies are of different types

3)Create a function that can take a List of AcceptedCurrency object and the cost of an item in Dollars,
 and return whether the user has sufficient funds in the list of currency objects to pay for what they are trying to buy
 */
class Wallet(var amount:Double, val type:AcceptedCurrency) {



    fun addMoney(money: Wallet) {
        if (this.type.exchangeRate > money.type.exchangeRate) {
            this.amount = this.amount + (money.amount / this.type.exchangeRate)

        }
        if (this.type.exchangeRate < money.type.exchangeRate) {
            this.amount = this.amount + (money.amount / money.type.exchangeRate)

        }

    }
    enum class AcceptedCurrency(val exchangeRate: Double) {
        US(1.0) {


        },
        CAN(0.8) {


        },
        AUS(1.2) {


        };



    }
}
fun buying(itemCost:Wallet,moneyList:List<Wallet>):Boolean{
    var total =Wallet(0.0,Wallet.AcceptedCurrency.US)
    for(wallets in moneyList)
    total.addMoney(wallets)

    println(total.amount)
    if(total.amount>=itemCost.amount) return true;
    return false
}