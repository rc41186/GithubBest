package com.android.githubbest.viewmodel.retrofit

import com.android.githubbest.model.GithubRepoTopContributor
import com.android.githubbest.model.GithubStarResponseModel
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

    @GET("/repos/{gitname}/{name}/contributors")
    fun getContributor(@Path("gitname") gitname : String,
                          @Path("name") name : String) : Call<ArrayList<GithubRepoTopContributor>>

}
