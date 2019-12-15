package com.brightwheel.githubbest.retrofit

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientService {

    private var githubServiceApi: GithubServiceApi ? = null

    val BASE_URL = "https://api.github.com/"

    fun createGithubApiServiceOkHttpClient() : GithubServiceApi {

        val okHttpClientBuilder = OkHttpClient.Builder()
        var client = okHttpClientBuilder.build()

        val githubRetrofit = Retrofit.Builder().baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .client(client)
                                .build()

        return githubRetrofit.create(GithubServiceApi::class.java)
    }
}   