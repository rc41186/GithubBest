package com.android.githubbest.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.githubbest.R
import com.android.githubbest.databinding.AdapterGithubRepoListBinding
import com.android.githubbest.model.GithubRepoTopContributor
import com.android.githubbest.model.GithubStarResultModel

/**
 * GithubListAdapter class used to bind the Github repo data to the RecyclerView for display.
 *
 * @param context - Access to application resources.
 *
 */
class GithubListAdapter(val context: Context?) : RecyclerView.Adapter<GithubListAdapter.GithubListViewHolder>() {

    var repo : ArrayList<GithubStarResultModel> = ArrayList()
    var topContributor : ArrayList<GithubRepoTopContributor?> = ArrayList()

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
        holder.bind(repo[position], topContributor[position])
    }

    fun setGitRepoList(repo : ArrayList<GithubStarResultModel>, topContributor: ArrayList<GithubRepoTopContributor?>){
        this.repo = repo
        this.topContributor = topContributor
        notifyDataSetChanged()
    }

    abstract inner class GithubViewHolder(root : View) : RecyclerView.ViewHolder(root) {
        abstract fun bind(result: GithubStarResultModel, contributor: GithubRepoTopContributor?)
    }

    inner class GithubListViewHolder(val binding: AdapterGithubRepoListBinding) : GithubViewHolder(binding.root) {
        override fun bind(result : GithubStarResultModel, contributor: GithubRepoTopContributor?) {
            val context = binding.root.context
            context?.let {
                binding.repo = result
                binding.contributor = contributor
                binding.notifyChange()
            }
        }
    }
}