package com.shopping.app

open class Checkout {
    //checks if the user entered any invaild items
    public fun verify (cart: MutableList<String>) : Boolean{
        for(item in cart){
            if(!item.equals("Apple") && !item.equals("Orange")){
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
                total=  total + 0.6;
            }
            if(item.equals("Orange") || item.equals("orange")){
                orangecount +=1;

                total=total +0.25;
            }
        }
        if(orangecount ==3){//buy three for the price of 2.step 2
            println("You qaulidified for our buy 3 oragnes for the price of 2 offer")
            total -=0.25;
        }
        if(applecount ==1){//buy one aple get 1 free. step 2
            println("You buy 1 apple get one free")
            cart.add("Apple");
        }

        return total;
    }
}