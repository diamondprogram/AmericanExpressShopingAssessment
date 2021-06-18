package com.shopping.app
import kotlin.system.exitProcess;
open class CustomerEventNotification {

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
}