package com.brightwheel.githubbest.viewmodel.contract


import android.content.Context

/**
 * A contract interface for the ViewModel methods, a clearer way to see which methods are needed for the View and the data Model
 *
 * WOULD-LIKE-TODO:
 *  - Add ViewModel interface with method definition <-- not used due to time constraint.
 *
 */
interface GithubListContract {

    interface View {
        fun initialize()
        fun getContext() : Context?
    }
}