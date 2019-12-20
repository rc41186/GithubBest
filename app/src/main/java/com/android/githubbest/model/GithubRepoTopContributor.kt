package com.android.githubbest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Github Top Contributors Model
 *
 * @param login - The user's github login
 */
data class GithubRepoTopContributor(@SerializedName("login") @Expose val login : String)