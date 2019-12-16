package com.brightwheel.githubbest.viewmodel.retrofit

import com.brightwheel.githubbest.model.GithubRepoContributor
import com.brightwheel.githubbest.model.GithubStarResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Retrofit Github Service API Definitions
 */
interface GithubServiceApi {
    @GET("/search/repositories?")
    fun getMostStarred(@Query("q") q : String,
                       @Query("sort") sort : String,
                       @Query("order") order : String,
                       @Query("per_page") per_page : Int) : Call<GithubStarResponseModel>

    @GET("/repos/{prename}/{name}/contributors")
    fun getTopContributor(@Path("prename") prename : String,
                          @Path("name") name : String) : Call<List<GithubRepoContributor>>

}
