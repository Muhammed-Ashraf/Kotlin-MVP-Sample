package com.uvionics.kotlinmvpsample.ui.main.interactor

import com.uvionics.kotlinmvpsample.model.PostModel
import com.uvionics.kotlinmvpsample.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface MainMVPInteractor : MVPInteractor {

    fun dogetPostsApiCall(): Observable<List<PostModel>>
}