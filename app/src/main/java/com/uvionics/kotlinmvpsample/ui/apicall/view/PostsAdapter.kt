package com.uvionics.kotlinmvpsample.ui.apicall.view

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.uvionics.kotlinmvpsample.R
import com.uvionics.kotlinmvpsample.model.PostModel
import kotlinx.android.synthetic.main.item_post.view.*


/**
 * Created by jyotidubey on 14/01/18.
 */
class PostsAdapter(private val postsList: MutableList<PostModel>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder = PostViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_post, parent, false))

    override fun getItemCount() = this.postsList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

//

    internal fun addPostsToList(posts: List<PostModel>) {
        this.postsList.addAll(posts)
        notifyDataSetChanged()
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {

        }

        fun onBind(position: Int) {

            val postModel = postsList[position]

            inflateData(postModel.title, postModel.body)

        }


        private fun inflateData(title: String?, body: String?) {
            title?.let { itemView.post_title.text = it }
            body?.let { itemView.post_body.text = it }

        }

    }
}
