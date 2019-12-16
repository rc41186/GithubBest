package com.brightwheel.githubbest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GithubRepoTopContributor(@SerializedName("login") @Expose val login : String)