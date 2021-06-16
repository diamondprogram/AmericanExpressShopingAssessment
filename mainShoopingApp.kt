package com.shopping.app

import java.util.Scanner;
import kotlin.system.exitProcess;
import app.Checkout;
    var shopRunning = true;
    fun main(args: Array<String>) {
        while (shopRunning) {
            //prints a welcome message along with what optins are avaible to the user
            println("Welcome to Express Store");
            println("1. Checkout");
            println("2. exit");
            var userOption = 0;
            //request the user to eneter an option
            //if user eneter a options that is not valid it will keep looping til option that is enterd is accepted;
            var userSeletedOption = false;
            val inputScanner = Scanner(System.`in`);
            while (!userSeletedOption) {
                print("Select an Option: ");
                userOption = inputScanner.nextInt();
                //if input entered by the user is not accepted and invaliud message is printed and is promted to enter an option again.
                if (userOption != 1 && userOption != 2) {
                    println("Invalid input detected!");
                } else {
                    userSeletedOption = true;
                }
            }

            if (userOption == 1) {
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

                if(checkout.verify(list)){ //checks if list has any item that is not an apple or orange
                   println("Thank you for your Pruchse");
                    val  cost = checkout.Chasher(list)
                    println("You bought: "+ list.toString());
                    print("your total is: "+ cost);//returns the total cost
                    exitProcess(1);//exits from the application
                }

            } else if (userOption == 2) {
                print("Have a great day.");
                exitProcess(1);
            }
        }
    }


