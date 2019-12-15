package com.brightwheel.githubbest.retrofit

import com.brightwheel.githubbest.model.GithubStarResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface GithubServiceApi {
    //https://api.github.com/search/repositories?q=stars&sort=stars&order=desc&per_page=5

    @GET("/repositories")
    fun getMostStarred(@Query("q") q : String,
                       @Query("sort") sort : String,
                       @Query("order") order : String,
                       @Query("per_page") per_page : Int) : Call <GithubStarResponseModel>

}

//https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=Trump