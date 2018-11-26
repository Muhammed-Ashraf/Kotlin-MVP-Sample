package com.uvionics.kotlinmvpsample.ui.main.view

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.uvionics.kotlinmvpsample.R
import com.uvionics.kotlinmvpsample.model.PostModel
import com.uvionics.kotlinmvpsample.ui.apicall.view.ApiCallFragment
import com.uvionics.kotlinmvpsample.ui.base.view.BaseActivity
import com.uvionics.kotlinmvpsample.ui.main.interactor.MainMVPInteractor
import com.uvionics.kotlinmvpsample.ui.main.presentor.MainMVPPresenter
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView, NavigationView.OnNavigationItemSelectedListener, HasSupportFragmentInjector {


    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager.findFragmentByTag(tag)?.let {
            supportFragmentManager.beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .remove(it)
                .commitNow()
        }
        unlockDrawer()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        presenter.onAttach(this)

        supportFragmentManager.beginTransaction().disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.containerLayout, ApiCallFragment.newInstance(), ApiCallFragment.TAG)
                .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_network -> {
                // Handle the camera action
            }
            R.id.nav_db -> {

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun displayPosts(postList: List<PostModel>) {

    }

    override fun lockDrawer() = drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

    override fun unlockDrawer() = drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
}
