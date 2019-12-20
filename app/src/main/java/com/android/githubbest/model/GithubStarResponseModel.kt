package com.android.githubbest.model

import com.google.gson.annotations.SerializedName

/**
 * Github Starred Response Model
 *
 * @param items - array of git hub repos
 */
data class GithubStarResponseModel(@SerializedName("items") val result: ArrayList<GithubStarResultModel>)
