package com.uvionics.kotlinmvpsample.ui.main.presentor


import com.uvionics.kotlinmvpsample.ui.base.presenter.BasePresenter
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallMVPInteractor
import com.uvionics.kotlinmvpsample.ui.main.interactor.MainMVPInteractor
import com.uvionics.kotlinmvpsample.ui.main.view.MainMVPView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by jyotidubey on 08/01/18.
 */

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, compositeDisposable = disposable), MainMVPPresenter<V, I> {


    override fun onAttach(view: V?) {
        super.onAttach(view)
        getPosts()
    }

    private fun getPosts() {
        getView()?.showProgress()

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