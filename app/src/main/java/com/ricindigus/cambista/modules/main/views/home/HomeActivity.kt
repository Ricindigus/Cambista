package com.ricindigus.cambista.modules.main.views.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ricindigus.cambista.R
import com.ricindigus.cambista.databinding.ActivityHomeBinding
import com.ricindigus.cambista.databinding.ActivityLoginBinding
import com.ricindigus.cambista.modules.authentication.views.login.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityHomeBinding
    private val mViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel
    }

    companion object{
        fun getIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}