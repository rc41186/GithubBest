package com.brightwheel.githubbest.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.brightwheel.githubbest.R
import com.brightwheel.githubbest.databinding.ActivityGithubRepoListBinding

class GithubRepoListActivity : BaseActivity() {

    private var binding : ActivityGithubRepoListBinding? = null
    private var githubListFragment = GithubListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_github_repo_list)
        initialize()
    }

    private fun initialize() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, githubListFragment)
        fragmentTransaction.commit()
    }
}