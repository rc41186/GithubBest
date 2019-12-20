package com.android.githubbest.viewmodel.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit Client Service class
 *
 * Purpose: Purpose of this class is to set the Github API base address into the
 * Retrofit client inorder to be used with the GithubServiceApi's definition.
 *
 */
open class RetrofitClientServiceManager private constructor() {
    private val BASE_URL = "https://api.github.com/"

    companion object {
        var manager : RetrofitClientServiceManager? = null
        fun getInstance() : RetrofitClientServiceManager {
            if(manager == null) {
                manager = RetrofitClientServiceManager()
            }
            return manager as RetrofitClientServiceManager
        }
    }

    /**
     * Create the Retrofit Client with Github's base URL.
     */
    private fun createGithubApiServiceOkHttpClient() : GithubServiceApi {

        val okHttpClientBuilder = OkHttpClient.Builder()
        var client = okHttpClientBuilder.build()

        val githubRetrofit = Retrofit.Builder().baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .client(client)
                                .build()

        return githubRetrofit.create(GithubServiceApi::class.java)
    }

    fun getGithubService() : GithubServiceApi {
        return createGithubApiServiceOkHttpClient()
    }
}   