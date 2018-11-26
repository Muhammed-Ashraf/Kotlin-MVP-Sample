package com.uvionics.kotlinmvpsample.ui.apicall.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.uvionics.kotlinmvpsample.R
import com.uvionics.kotlinmvpsample.model.PostModel
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallMVPInteractor
import com.uvionics.kotlinmvpsample.ui.apicall.presenter.ApiCallMVPPresenter
import com.uvionics.kotlinmvpsample.ui.base.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_api_call.*
import javax.inject.Inject


class ApiCallFragment : BaseFragment(), ApiCallMVPView {


    @Inject
    internal lateinit var postsAdapter: PostsAdapter

    @Inject
    internal lateinit var presenter: ApiCallMVPPresenter<ApiCallMVPView, ApiCallMVPInteractor>

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    companion object {

        internal const val TAG = "APICallFragment"

        @JvmStatic
        fun newInstance() = ApiCallFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_api_call, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        postRecyclerView.layoutManager = layoutManager
        postRecyclerView.itemAnimator = DefaultItemAnimator()
        postRecyclerView.adapter = postsAdapter
        presenter.onViewPrepared()
    }

    override fun displayPosts(postList: List<PostModel>) {
        loadingLayout.visibility = View.INVISIBLE
        postRecyclerView.visibility = View.VISIBLE
        postsAdapter.addPostsToList(postList)
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }
}
