package com.cs4520.assignment4

import androidx.lifecycle.LiveData

class ProductRepository(private val apiService: ApiService, private val productDao: ProductDAO) {
    suspend fun fetchProducts(): LiveData<List<ProductModel>> {
        val products = apiService.getProducts(1)
        val body = products.body()
        print("ProductRepository: ${body}\n")

        // send the request to the server and insert the products into the database
        if (products.isSuccessful) {
            print("Succ ProductRepository: ${products}\n")
            productDao.insertAll(
                products.body()?.map { product ->
                    ProductModel(
                        product.name,
                        product.price,
                        product.expiryDate,
                        product.type
                    )
                } ?: emptyList()
            )
        }

        val productsFromDb : LiveData<List<ProductModel>> = productDao.getAllProducts()

        print("FinishedRepo: ${productsFromDb.value}\n")
        return productsFromDb
    }
}
