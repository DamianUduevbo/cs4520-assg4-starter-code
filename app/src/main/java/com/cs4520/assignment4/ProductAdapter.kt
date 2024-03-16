package com.cs4520.assignment4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment4.R

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.productTypeImage)
        val productNameTextView: TextView = itemView.findViewById(R.id.productName)
        val productPriceTextView: TextView = itemView.findViewById(R.id.productPrice)
        val productExpiryDateTextView: TextView = itemView.findViewById(R.id.expiryDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    fun getProductName(product: Product): String {
        return when (product) {
            is Product.FoodProduct -> product.name
            is Product.EquipmentProduct -> product.name
        }
    }

    fun getProductPrice(product: Product): Int {
        return when (product) {
            is Product.FoodProduct -> product.price
            is Product.EquipmentProduct -> product.price
        }
    }

    fun getProductExpiryDate(product: Product): String? {
        return when (product) {
            is Product.FoodProduct -> product.expiryDate
            is Product.EquipmentProduct -> null
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productImageView.setImageResource(
            when (product) {
                is Product.FoodProduct -> R.drawable.food
                is Product.EquipmentProduct -> R.drawable.equipment
            }
        )

        holder.productNameTextView.text = getProductName(product)
        holder.productPriceTextView.text = "$${getProductPrice(product)}"

        // if the product is a food product, set the expiry date and background color
        when (product) {
            is Product.FoodProduct -> {
                holder.productExpiryDateTextView.text = getProductExpiryDate(product)
                holder.itemView.setBackgroundResource(R.color.yellow)
            }
            is Product.EquipmentProduct -> {
                holder.productExpiryDateTextView.text = ""
                holder.itemView.setBackgroundResource(R.color.red)
            }
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}