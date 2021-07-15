package com.github.carvaldo.fimo.datasource.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("SearchMovie/"+ ServiceGenerator.API_KEY +"/{query}")
    fun search(@Path("query") query: String): Call<SearchResult>
}