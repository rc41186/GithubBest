package com.brightwheel.githubbest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.brightwheel.githubbest.R
import com.brightwheel.githubbest.databinding.FragmentGithubCardListBinding
import com.brightwheel.githubbest.model.GithubRepoTopContributor
import com.brightwheel.githubbest.model.GithubStarResultModel
import com.brightwheel.githubbest.viewmodel.retrofit.RetrofitClientServiceManager
import com.brightwheel.githubbest.viewmodel.contract.GithubListContract

/**
 * Fragment response for displaying list of top 100 starred Github repositories.
 *
 */

class GithubListFragment : Fragment(), GithubListContract.View {

    private lateinit var binding : FragmentGithubCardListBinding
    private lateinit var githubRepoAdapter : GithubListAdapter

    /**
     * Create an instance of this fragment for fragment transaction purposes.
     */
    companion object {
        fun newInstance():GithubListFragment {
            return GithubListFragment()
        }
    }

    override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_github_card_list, container, false)
        initialize()
        getGithubRepoData()
        return binding.root
    }

    override fun initialize() {
        githubRepoAdapter =
            GithubListAdapter(context)
        binding.githubRepoList.layoutManager = LinearLayoutManager(context)
        binding.githubRepoList.adapter = githubRepoAdapter
    }

    /**
     * Initializes a Github API service using Retrofit to query in descending order of the top 100 starred repos.
     *
     * WOULD-LIKE-TODO:
     *  - Better way to handle the query pararms when calling getMostStarred method. Seems like these params
     *  wouldn't probably called that often, so could probably use in the API definition.
     *
     *  - need to move this into a Repository class
     */
    private fun getGithubRepoData() {
        val result = RetrofitClientServiceManager.getInstance().getGithubService().getMostStarred("stars", "stars", "desc", 100)
        val stars : ArrayList<GithubStarResultModel> = result.execute().body()!!.result
        getRepoTopContributor(stars)
    }

    /**
     * Gets the Top Contributors by Repo
     *
     * @param items - The list of starred repots
     *
     * TODO: Need to refactor, should be async due to the amount of calls.
     *
     * Issue - 60 class are allowed within an hour - this caused a delays in implementation.
     */
    private fun getRepoTopContributor(items : ArrayList<GithubStarResultModel>) {
        val topContributorList : ArrayList<GithubRepoTopContributor?> = ArrayList()
        for(data in items) {
            var qualifedName = data.full_name.split("/")
            val result = RetrofitClientServiceManager.getInstance().getGithubService().getContributor(qualifedName[0], qualifedName[1])
            val contributor = result.execute().body()?.get(0)
            topContributorList.add(contributor)
        }
        githubRepoAdapter.setGitRepoList(items, topContributorList)
    }
}