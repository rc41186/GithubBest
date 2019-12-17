package com.brightwheel.githubbest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brightwheel.githubbest.R
import android.os.StrictMode


/**
 *  Base Activity class
 *
 *  Purpose: Base activity class to for child activity class to inherit
 *  commonly used methods, variables for operations.
 *
 *  WOULD-LIKE-TODO:
 *      - Have a progress bar while data is being loaded
 *      - Set a toolbar
 *
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Allow network calls on main thread - temp hack, not appropriate, calls should be async
         * running on different threads.
         */
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

}
