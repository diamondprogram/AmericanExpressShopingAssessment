package com.shopping.app

import java.util.Scanner;
import kotlin.system.exitProcess;
import  java.util.EventListener;
import com.shopping.app.Checkout;
import com.shopping.app.CustomerEventNotification;
import com.shopping.app.Apple;
import com.shopping.app.Orange;
var shopRunning = true;
var applecount = 0;
fun main(args: Array<String>) {
    val inputScanner = Scanner(System.`in`);
    var stockNotvaild = true;
    while (shopRunning) {


        val apple = Apple();// I created class for them so i would need to keep resending the current stock of item sbetween class
        val orange = Orange();

        var applelist: MutableList<String> = ArrayList();//this will be used to keep track of how many of each item is in the cart
        var orangelist: MutableList<String> = ArrayList();

        //prints a welcome message along with what optins are avaible to the user
        println("Welcome to Express Store");
        println("1. Checkout");
        println("2. exit");
        var userOption = "";
        //request the user to eneter an option
        //if user eneter a options that is not valid it will keep looping til option that is enterd is accepted;
        var userSeletedOption = false;

        while (!userSeletedOption) {
            print("Select an Option: ");
            userOption = inputScanner.next();
            //if input entered by the user is not accepted and invaliud message is printed and is promted to enter an option again.
            if (userOption != "1" && userOption != "2") {
                println("Invalid input detected!");
            } else {
                userSeletedOption = true;
            }
        }

        if (userOption == "1") {
            val checkout = Checkout();
            println("We currently have ${apple.getStock()}  apples and ${orange.getStock()} oranges in Stock.")




            var list: MutableList<String> = ArrayList();


            var cart: MutableList<String> = ArrayList();
            println(list.size);
            var doneAddingToCart = false;
            print("enter name of item to be enter or exit to finish adding to the cart (seperate each item by a space): ")
            while(!doneAddingToCart){

                var item = inputScanner.nextLine();
                if(!cart.isEmpty()){
                    doneAddingToCart=true;
                }

                 cart = item.split(" ").toMutableList();

               for(item in cart){//goes through the item in the list and checks if it and apple or orange and appends them to the apporiate list
                   if(item.equals("Apple") || item.equals("apple")){
                       applelist.add(item);
                   }else if(item.equals("orange") || item.equals("Orange")){
                       applelist.add(item);
                   }
               }


            }



            val notify = CustomerEventNotification();//this will create an instance of th notification service
            //now checks if the stock enter into the user cart is more than what the store current have
            if(applelist.size> apple.getStock() || orangelist.size > orange.getStock()){//if eaither item exceed the limit the user will be sent a message to warn them
                if(applelist.size>apple.getStock() && orangelist.size>orange.getStock()){
                    notify.exceeded(applelist,orangelist);
                }else if(applelist.size>apple.getStock()){
                    notify.exceeded(applelist,"apple");
                }else if(orangelist.size>orange.getStock()){
                    notify.exceeded(orangelist,"orange");
                }
            }
            else if((applelist.size<= apple.getStock() && orangelist.size <= orange.getStock())&& checkout.verify(cart)){ //checks if list has any item that is not an apple or orange
                val  cost = checkout.Chasher(cart);

                if(cost == 0.0){// if cost is zero, either a error happen or the list was empty
                        notify.notification(false,cart);
                }else if(cost>0.0){
                    notify.notification(true,cart,cost);
                }
            }else{//if an item in the list is in valid, the user will be alerted
                notify.notification(false,cart);
            }


        } else if (userOption == "2") {// exits from the application
            print("Have a great day.");
            exitProcess(0);
        }
    }
}


