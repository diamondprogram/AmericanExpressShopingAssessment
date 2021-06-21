package com.shopping.app

import java.util.Scanner;
import kotlin.system.exitProcess;
import  java.util.EventListener;
import com.shopping.app.Checkout;
import com.shopping.app.CustomerEventNotification;
var shopRunning = true;
var applecount = 0;
fun main(args: Array<String>) {

    while (shopRunning) {
        //prints a welcome message along with what optins are avaible to the user
        println("Welcome to Express Store");
        println("1. Checkout");
        println("2. exit");
        var userOption = "";
        //request the user to eneter an option
        //if user eneter a options that is not valid it will keep looping til option that is enterd is accepted;
        var userSeletedOption = false;
        val inputScanner = Scanner(System.`in`);
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
            println("We currently have apples and oranges in Stock.")




            var list: MutableList<String> = ArrayList();



            println(list.size);
            var doneAddingToCart = false;
            while(!doneAddingToCart){
                print("enter name of item to be enter or exit to finish adding to the cart: ")
                var item = inputScanner.next();
                if(item.equals("exit")){
                    doneAddingToCart=true;
                }
                else{
                    list.add(item);
                }
            }

            val notify = CustomerEventNotification();

            if(checkout.verify(list)){ //checks if list has any item that is not an apple or orange
                val  cost = checkout.Chasher(list)

                if(cost == 0.0){// if cost is zero, either a error happen or the list was empty
                        notify.notification(false,list);
                }else if(cost>0.0){
                    notify.notification(true,list,cost);
                }
            }else{//if an item in the list is in valid, the user will be alerted
                notify.notification(false,list);
            }

        } else if (userOption == "2") {// exits from the application
            print("Have a great day.");
            exitProcess(1);
        }
    }
}


