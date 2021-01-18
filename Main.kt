import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

fun main(){
  /*  Observable.just("Apple", "Orange", "Banana")
        .subscribe(
            { value -> println("Received: $value") }, // onNext
            { error -> println("Error: $error") },    // onError
            { println("Completed!") }                 // onComplete
        )
*/
    /*getObservableFromList(listOf("Apple", "", "Banana"))
        .subscribe({ v-> println("REceived: $v")},
            {e -> println("error: $e")}

        )*/
    /*Observable.intervalRange(
        1L,     // Start
        30L,      // Count
        0L,      // Initial Delay
        1L,      // Period
        TimeUnit.SECONDS
    ).subscribe { println("Result we just received: $it") }*/

    /*Observable.interval(4000, TimeUnit.MILLISECONDS)
        .subscribe { println("Result we just received: $it") }*/



    /*val observable = PublishSubject.create<Int>()
    observable.observeOn(Schedulers.computation())
        .subscribe (
            {
                println("The Number Is: $it")
            },
            {t->
                print(t.message)
            }
        )
    for (i in 0..1000000){
        observable.onNext(i)
    }*/

    val observable = PublishSubject.create<Int>()
    observable
        .toFlowable(BackpressureStrategy.DROP)
        .observeOn(Schedulers.computation())
        .subscribe (
            {
                println("The Number Is: $it")
            },
            {t->
                print(t.message)
            }
        )
    for (i in 0..1000000){
        observable.onNext(i)
    }









}

fun getObservableFromList(myList:List<String>)=
    Observable.create<String>{
        emitter -> myList.forEach { kind->
        if (kind=="") {
            emitter.onError(Exception("There's no value to show"))
        }

        emitter.onNext(kind)

        }
        emitter.onComplete()
    }



