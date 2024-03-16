package com.cs4520.assignment4

sealed class Product {
    data class FoodProduct(
        val name: String,
        val expiryDate: String?,
        val price: Int
    ) : Product()

    data class EquipmentProduct(
        val name: String,
        val price: Int
    ) : Product()
}