package com.uvionics.kotlinmvpsample.ui.apicall.view


import com.uvionics.kotlinmvpsample.model.PostModel
import com.uvionics.kotlinmvpsample.ui.base.view.MVPView

/**
 * Created by jyotidubey on 13/01/18.
 */
interface ApiCallMVPView : MVPView {

    fun displayPosts(postList: List<PostModel>)
}