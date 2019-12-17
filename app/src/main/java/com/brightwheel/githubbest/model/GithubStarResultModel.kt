package com.brightwheel.githubbest.model

import com.google.gson.annotations.SerializedName

/**
 *  Github Starred Repo Object Models
 *
 *  @param name - The name of the repo
 *  @param desc - The repo description
 *  @param url - The url to the github repo
 *  @param starGazerCount - The starred count
 *  @param full_name - The repo's full name
 */
data class GithubStarResultModel(@SerializedName("name") val name : String,
                                 @SerializedName("description") val desc : String,
                                 @SerializedName("url") val url : String,
                                 @SerializedName("stargazers_count") val starGazerCount : String,
                                 @SerializedName("full_name") val full_name : String)