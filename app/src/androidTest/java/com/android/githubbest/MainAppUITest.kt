package com.android.githubbest

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.githubbest.view.GithubRepoListActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainAppUITest {

    @JvmField
    @Rule
    var intentsTestRule: IntentsTestRule<GithubRepoListActivity> = IntentsTestRule(GithubRepoListActivity::class.java, true, false)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.brightwheel.githubbest", appContext.packageName)
    }

    @Test
    fun verifyGitListItem() {

    }
}
