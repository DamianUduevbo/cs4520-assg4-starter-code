package com.cs4520.assignment4

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// ViewModel class for the product list
class ProductListViewModel : ViewModel() {
    private lateinit var repo: ProductRepository
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products
    private val _loading = MutableLiveData<Boolean>()

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error
    private val _noProducts = MutableLiveData<Boolean>()

    // Initialize the repository
    fun initialize(repository: ProductRepository) {
        this.repo = repository
    }

    // Fetch the products from the repository
    fun fetchProducts() {
        viewModelScope.launch {
            _loading.value = true

            try {
                val productList = repo.fetchProducts()
                Log.d("ProductListViewModel", "Product list: ${productList.value}")

                if (!productList.value.isNullOrEmpty()) {
                    _products.value = productList.value!!.mapNotNull { it.toProduct() }
                } else {
                    _noProducts.value = true
                }

            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false

            }
        }
    }
}