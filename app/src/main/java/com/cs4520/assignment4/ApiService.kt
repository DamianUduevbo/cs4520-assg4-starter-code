package com.cs4520.assignment4

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Api.ENDPOINT)
    // get products from the server
    suspend fun getProducts(@Query("page") pageNumber: Int?) : Response<List<ProductModel>>
}