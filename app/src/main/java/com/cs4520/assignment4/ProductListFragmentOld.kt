package com.cs4520.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment4.databinding.FragmentProductListBinding
import com.cs4520.assignment4.R

/*
class ProductListFragmentOld : Fragment() {
    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductViewModel by viewModels()

    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
        viewModel.fetchProducts()
    }

    private fun setupRecyclerView() {
        recyclerView = binding.productRecyclerView
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = ProductAdapter()
        }
    }

    private fun observeViewModel() {
        viewModel.products.observe(viewLifecycleOwner) { products ->
            (recyclerView.adapter as ProductAdapter).submitList(products)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.loadingText.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.isEmpty.observe(viewLifecycleOwner) { isEmpty ->
            binding.emptyText.visibility = if (isEmpty) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
*/

/*
class ProductListFragment : Fragment() {
    private val data = productsDataset.map {
        val productName : String = it[0] as String
        //val productType : String = it[1] as String
        val productExpiryDate : String? = it[2] as String?
        val productPrice = it[3] as Int

        if (it[1] == "Food") {
            Product.FoodProduct(productName, productExpiryDate, productPrice)
        } else {
            Product.EquipmentProduct(productName, productPrice)
        }
    }

    private var productsAdapter = ProductAdapter(data)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productRecyclerView)
        recyclerView.adapter = productsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }
}
*/