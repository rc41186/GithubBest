package com.brightwheel.githubbest.model

import com.google.gson.annotations.SerializedName

data class GithubRepoTopContributor(@SerializedName("login") val login : String)