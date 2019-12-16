package com.brightwheel.githubbest.model

import com.google.gson.annotations.SerializedName

data class GithubStarResultModel(@SerializedName("name") val name : String,
                                 @SerializedName("description") val desc : String,
                                 @SerializedName("url") val url : String,
                                 @SerializedName("stargazers_count") val starGazerCount : String,
                                 @SerializedName("full_name") val full_name : String)