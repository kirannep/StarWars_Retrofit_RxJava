package com.example.starwarapi_retrofit_rxjava.network

import com.example.starwarapi_retrofit_rxjava.model.Results
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GetPersonRequest {
    @GET("people")
    fun getpersonRequest() : Observable<List<Results>>

}