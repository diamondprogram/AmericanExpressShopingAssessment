package com.shopping.app
import kotlin.system.exitProcess;
import com.shopping.app.Apple;
import com.shopping.app.Orange;
open class CustomerEventNotification {
    var apple = Apple();
    var orange = Orange();
    public fun notification (success: Boolean, list: MutableList<String>, cost: Double = 0.0){// in case of failure/false boolean value is passed we have a defualt value for cost since if the verification
                                                                                                // fails the the chasher function would never be called nor would the cost intiallized
        if(success == true){
            println("Thank you for your Pruchse");

            println("You bought: "+ list.toString());
            println("your total is: "+ cost);//returns the total cost
            println("Your estimated Divlivery time is 2 hours");
            exitProcess(0);//exits from the application
        }else{
            println("Something went wrong with your order");

            println("Make sure you have entered only items that are in stock [Apple or Orange]");
            println("you have "+ list.toString()+ " in your cart");
            println("please try again");
        }
    }
    public fun exceeded(list: MutableList<String>, itemName: String){//if one item exceed the stock limit
        println("the number of ${itemName} in your cart exceeds our stock of ${list.size} ${itemName}s")

    }
    public fun exceeded(applelist: MutableList<String>,orangelist: MutableList<String>){//if both items exceed the stock limit
        println("Both items in your cart exceed the maximum Limit")
        println("We Have ${apple.getStock()} apples in stock, you ordered ${applelist.size} apples.")
        println("We Have ${orange.getStock()} oranges in stock, you ordered ${orangelist.size} oranges.")
    }
}