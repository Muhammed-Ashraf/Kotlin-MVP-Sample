package com.uvionics.kotlinmvpsample.ui.apicall


import android.support.v7.widget.LinearLayoutManager
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallInteractor
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallMVPInteractor
import com.uvionics.kotlinmvpsample.ui.apicall.presenter.ApiCallMVPPresenter
import com.uvionics.kotlinmvpsample.ui.apicall.presenter.ApiCallPresenter
import com.uvionics.kotlinmvpsample.ui.apicall.view.ApiCallFragment
import com.uvionics.kotlinmvpsample.ui.apicall.view.ApiCallMVPView
import com.uvionics.kotlinmvpsample.ui.apicall.view.PostsAdapter
import dagger.Module
import dagger.Provides
import java.util.*

/**
 * Created by jyotidubey on 14/01/18.
 */
@Module
class ApiCallFragmentModule {

    @Provides
    internal fun provideApiCallInteractor(interactor: ApiCallInteractor): ApiCallMVPInteractor = interactor

    @Provides
    internal fun provideApiCallPresenter(presenter: ApiCallPresenter<ApiCallMVPView, ApiCallMVPInteractor>)
            : ApiCallMVPPresenter<ApiCallMVPView, ApiCallMVPInteractor> = presenter

    //
    @Provides
    internal fun provideApiCallAdapter(): PostsAdapter = PostsAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: ApiCallFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)


}