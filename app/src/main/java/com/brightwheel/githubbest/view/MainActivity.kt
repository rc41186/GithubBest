package com.brightwheel.githubbest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brightwheel.githubbest.R
import com.brightwheel.githubbest.retrofit.GithubServiceApi
import com.brightwheel.githubbest.retrofit.RetrofitClientService
import retrofit2.await
import retrofit2.awaitResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitClient = RetrofitClientService()
        val githubServiceApi = retrofitClient.createGithubApiServiceOkHttpClient()

        val result = githubServiceApi.getMostStarred("stars", "stars", "desc", 5)

        println(result)
    }
}
