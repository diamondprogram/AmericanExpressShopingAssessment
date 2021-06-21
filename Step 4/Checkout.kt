package com.shopping.app

import com.shopping.app.Apple;
import com.shopping.app.Orange;

open class Checkout {
    //checks if the user entered any invaild items
    var apple = Apple();
    var orange = Orange();
    public fun verify (cart: MutableList<String>) : Boolean{
        for(item in cart){
            if(!item.equals("Apple") && !item.equals("Orange") && !item.equals("apple")&& !item.equals("orange")){
                return false;
            }
        }
        return true;
    }

    public fun Chasher (cart: MutableList<String>) : Double{
        var total = 0.0;


        var orangecount = 0;//step 2 offers
        var applecount = 0;//step 2 offers

        for(item in cart){//step 1 function
            if(item.equals("Apple") || item.equals("apple")){
                applecount+=1;
                apple.setStock(apple.getStock()-1); //step 3 removes 1 apple from the stock for every apple in the "cart"
                total=  total + apple.getCost();
            }
            if(item.equals("Orange") || item.equals("orange")){
                orangecount +=1;
                orange.setStock(orange.getStock()-1) //step 3 removes 1 orange from the stock for every orange in the "cart"
                total=total +orange.getCost();
            }
        }
        if(orangecount ==3){//buy three for the price of 2.step 2
            println("You qaulidified for our buy 3 oragnes for the price of 2 offer")
            total -=0.25;
        }
        if(applecount ==1 && apple.getStock() <1){//buy one aple get 1 free. step 2
            //if stock current stock is less than 1 the user is unable to recived the offer
            println("You buy 1 apple get one free")
            cart.add("Apple");
        }

        return total;
    }
}