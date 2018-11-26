package com.uvionics.kotlinmvpsample.ui.base.interactor

import com.uvionics.kotlinmvpsample.data.network.NetworkApiHelper


/**
 * Created by jyotidubey on 04/01/18.
 */
open class BaseInteractor() : MVPInteractor {

    protected lateinit var apiHelper: NetworkApiHelper

    //TODO
//    protected lateinit var preferenceHelper: PreferenceHelper
//    protected lateinit var apiHelper: ApiHelper
//TODO
    constructor(apiHelper: NetworkApiHelper) : this() {
//        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

}