package com.uvionics.kotlinmvpsample.ui.main.view

import com.uvionics.kotlinmvpsample.model.PostModel
import com.uvionics.kotlinmvpsample.ui.base.view.MVPView

interface MainMVPView : MVPView {

    //    fun inflateUserDetails(userDetails: Pair<String?, String?>)
//    fun displayQuestionCard(questionCard: List<QuestionCardData>)
//    fun openLoginActivity()
//    fun openFeedActivity()
//    fun openAboutFragment()
//    fun openRateUsDialog(): Unit?
//    fun lockDrawer(): Unit?
//    fun unlockDrawer(): Unit?
    fun displayPosts(postList: List<PostModel>)
    fun lockDrawer(): Unit?
    fun unlockDrawer(): Unit?
}