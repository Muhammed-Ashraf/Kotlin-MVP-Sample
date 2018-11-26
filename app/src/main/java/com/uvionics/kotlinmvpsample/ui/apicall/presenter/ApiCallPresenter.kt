package com.uvionics.kotlinmvpsample.ui.apicall.presenter

import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallInteractor
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallMVPInteractor
import com.uvionics.kotlinmvpsample.ui.apicall.view.ApiCallMVPView
import com.uvionics.kotlinmvpsample.ui.base.presenter.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 13/01/18.
 */
class ApiCallPresenter<V : ApiCallMVPView, I : ApiCallMVPInteractor> @Inject constructor(interactor: I, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, compositeDisposable = compositeDisposable), ApiCallMVPPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            interactor?.let {
                compositeDisposable.add(it.dogetPostsApiCall()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ postsList ->
                            //                        updateUserInSharedPref(loginResponse = loginResponse,
//                                loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_FB)
                            getView()?.let {
                                it.hideProgress()
                                if (postsList.isEmpty()) return@subscribe
                                else it.displayPosts(postsList)
                            }
                        }, { err -> println(err) })
                )

            }
        }
    }
}