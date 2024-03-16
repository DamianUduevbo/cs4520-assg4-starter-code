package com.cs4520.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs4520.assignment4.databinding.FragmentProductListBinding

// use internet permissions
import com.cs4520.assignment4.Retrofit

// Product list fragment class
class ProductListFragment : Fragment() {
    private lateinit var viewModel: ProductListViewModel
    private lateinit var binding: FragmentProductListBinding
    private lateinit var productAdapter: ProductAdapter

    // Inflate the layout for this fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService = Retrofit.api
        val productDao = ProdDatabase.getInstance(requireContext()).productDao()
        val repo = ProductRepository(apiService, productDao)

        viewModel = ViewModelProvider(this)[ProductListViewModel::class.java]
        viewModel.initialize(repo)

        productAdapter = ProductAdapter(emptyList())
        binding.productRecyclerView.adapter = productAdapter
        binding.productRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.fetchProducts()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.products.observe(viewLifecycleOwner) { products ->
            // Update the entire dataset when receiving updates
            productAdapter = ProductAdapter(products)
            binding.productRecyclerView.adapter = productAdapter
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
        }

        /*
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading)
        }

        viewModel.noProducts.observe(viewLifecycleOwner) { noProd ->
            binding.noProducts.visibility = if (noProd)
        }
        */
    }
}