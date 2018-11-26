package com.uvionics.kotlinmvpsample.data.network

import com.uvionics.kotlinmvpsample.model.PostModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface NetworkApiHelper {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<PostModel>>
}