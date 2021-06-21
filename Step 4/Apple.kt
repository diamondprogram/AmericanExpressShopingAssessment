package com.shopping.app

import kotlin.random.Random

class Apple {

    private val cost = 0.6;
    private var stock = 3

    public fun getCost(): Double{//gets the cost
        return this.cost;
    }
    public fun getStock(): Int{//gets the current stock
        return this.stock;
    }

    public fun setStock(newStock: Int) {//set the new stock
        this.stock = newStock;
    }

}