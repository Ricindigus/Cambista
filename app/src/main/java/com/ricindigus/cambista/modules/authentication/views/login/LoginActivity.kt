package com.ricindigus.cambista.modules.authentication.views.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.ricindigus.cambista.R
import com.ricindigus.cambista.databinding.ActivityLoginBinding
import com.ricindigus.cambista.modules.main.views.home.HomeActivity
import com.ricindigus.cambista.utils.toast
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = loginViewModel
        subscribeObservers()
    }

    private fun subscribeObservers() {
        loginViewModel.getUserValue().observe(this, Observer {
            loginViewModel.validateFields()
        })

        loginViewModel.getPasswordValue().observe(this, Observer {
            loginViewModel.validateFields()
        })

        loginViewModel.initSession.observe(this, Observer { initSession->
            if (initSession){
                openHomeActivity()
                loginViewModel.finishInitSessionProcess()
            }
        })

        loginViewModel.showError.observe(this, Observer { showNow ->
            if (showNow) {
                toast(getString(R.string.error_text))
                loginViewModel.finishShowError()
            }
        })

        loginViewModel.showLoading.observe(this, Observer { showNow ->
            if (showNow) showLoading()
            else hideLoading()
        })
    }

    private fun openHomeActivity() {
        startActivity(HomeActivity.getIntent(this))
        finish()
    }

    private fun showLoading() {
        loginViewModel.showLoading()
    }

    private fun hideLoading() {
        loginViewModel.hideLoading()
    }

    companion object{
        fun getIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}