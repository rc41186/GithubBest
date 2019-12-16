package com.brightwheel.githubbest.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.brightwheel.githubbest.R
import com.brightwheel.githubbest.databinding.AdapterGithubRepoListBinding
import com.brightwheel.githubbest.model.GithubRepoContributor
import com.brightwheel.githubbest.model.GithubRepoTopContributor
import com.brightwheel.githubbest.model.GithubStarResultModel
import com.brightwheel.githubbest.viewmodel.retrofit.RetrofitClientServiceManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * GithubListAdapter class used to bind the Github repo data to the RecyclerView for display.
 *
 * @param context - Access to application resources.
 *
 */
class GithubListAdapter(val context: Context?) : RecyclerView.Adapter<GithubListAdapter.GithubListViewHolder>() {

    var repo : ArrayList<GithubStarResultModel> = ArrayList()
    var topContributor : GithubRepoTopContributor? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubListViewHolder {
        return GithubListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_github_repo_list, parent, false))
    }

    override fun getItemCount(): Int {
        return repo.size
    }

    /**
     * onBindViewHolder is responsible for binding the data to the view holder.
     *
     * This method will make another Retrocall to get the top contributor for that particular
     * repo
     *
     * @param holder - The "row" in the recycler view grid.
     * @param position - The position of the grid within the RecyclerView
     */
    override fun onBindViewHolder(holder: GithubListViewHolder, position: Int) {
        var qualifedName = repo[position].full_name.split("/")

        getRepoTopContributor(qualifedName[0], qualifedName[1])

        holder.bind(repo[position])
    }

    /**
     * Gets the Top Contributors by Repo
     *
     * @param githubName - the github name of the repo
     * @param repoName - repo's name
     *
     * TODO: need to move this into a Repository class
     *
     * Issue - 60 class are allowed within an hour - this caused a delays in implementation.
     */
    private fun getRepoTopContributor(githubName:String, repoName:String) {
        val result = RetrofitClientServiceManager.getInstance().getGithubService().getTopContributor(githubName, repoName)
        result.enqueue(object : Callback<List<GithubRepoContributor>> {
            override fun onResponse(
                call: Call<List<GithubRepoContributor>>,
                response: Response<List<GithubRepoContributor>>
            ) {
                println(response.body()?.get(0)?.result)
            }
            override fun onFailure(call: Call<List<GithubRepoContributor>>, t: Throwable) {
                println(t)
            }
        })
    }

    fun setGitRepoList(repo : ArrayList<GithubStarResultModel>){
        this.repo = repo
        notifyDataSetChanged()
    }

    abstract inner class GithubViewHolder(root : View) : RecyclerView.ViewHolder(root) {
        abstract fun bind(result: GithubStarResultModel)
    }

    inner class GithubListViewHolder(val binding: AdapterGithubRepoListBinding) : GithubViewHolder(binding.root) {
        override fun bind(result : GithubStarResultModel) {
            val context = binding.root.context
            context?.let {
                binding.repo = result
                binding.contributor = topContributor
                binding.notifyChange()
            }
        }
    }
}