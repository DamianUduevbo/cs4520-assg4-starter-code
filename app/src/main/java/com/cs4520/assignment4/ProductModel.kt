package com.cs4520.assignment4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductModel (
    @PrimaryKey val name : String,
    val price : Double,
    val expiryDate: String?,
    val type: String
) {
    fun toProduct(): Product? {
        return when (type) {
            "Food" -> Product.FoodProduct(name, expiryDate, price.toInt())
            "Equipment" -> Product.EquipmentProduct(name, price.toInt())
            else -> null
        }
    }
}