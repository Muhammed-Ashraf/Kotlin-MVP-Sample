package com.uvionics.kotlinmvpsample.ui.apicall.interactor

import com.uvionics.kotlinmvpsample.data.network.NetworkApiHelper
import com.uvionics.kotlinmvpsample.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class ApiCallInteractor @Inject internal constructor(apiHelper: NetworkApiHelper) : BaseInteractor(apiHelper = apiHelper), ApiCallMVPInteractor {
    override fun dogetPostsApiCall() = apiHelper.getPosts()

}