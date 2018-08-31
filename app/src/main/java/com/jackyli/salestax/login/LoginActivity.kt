package com.jackyli.salestax.login

import com.jackyli.salestax.BaseActivity
import com.jackyli.salestax.MainApplication
import com.jackyli.salestax.R
import com.jackyli.salestax.login.di.DaggerLoginComponent
import com.jackyli.salestax.login.di.LoginModule
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginPresenter>() {
  @Inject
  lateinit var loginPresenter: LoginPresenter

  override fun getPresenter(): LoginPresenter {
    return loginPresenter
  }

  override fun initialiseView() {
    login_username.setText(R.string.username)
    login_password.setText(R.string.password)
    with(login_button) {
      setOnClickListener { login() }
    }
  }

  override fun initialiseInjector() {
    DaggerLoginComponent.builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .loginModule(LoginModule())
            .build()
            .inject(this)
  }

  override fun getLayout(): Int {
    return R.layout.activity_login
  }

  fun login() {
    loginPresenter.login(resources.getString(R.string.username), resources.getString(R.string.password))
  }
}