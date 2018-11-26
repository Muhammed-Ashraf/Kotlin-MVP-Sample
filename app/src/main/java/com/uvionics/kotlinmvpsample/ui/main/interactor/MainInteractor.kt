package com.uvionics.kotlinmvpsample.ui.main.interactor

import com.uvionics.kotlinmvpsample.data.network.NetworkApiHelper
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallMVPInteractor
import com.uvionics.kotlinmvpsample.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class MainInteractor @Inject internal constructor(apiHelper: NetworkApiHelper) : BaseInteractor(apiHelper = apiHelper), MainMVPInteractor {
    override fun dogetPostsApiCall() = apiHelper.getPosts()

}