package com.brightwheel.githubbest.model

import com.google.gson.annotations.SerializedName

data class GithubStarResponseModel(@SerializedName("items") val result: ArrayList<GithubStarResultModel>)
