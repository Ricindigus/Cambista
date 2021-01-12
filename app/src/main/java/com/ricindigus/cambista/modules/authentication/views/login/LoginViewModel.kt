package com.ricindigus.cambista.modules.authentication.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ricindigus.cambista.datasource.remote.service.Failure
import com.ricindigus.cambista.datasource.remote.service.NetworkStatusChecker
import com.ricindigus.cambista.datasource.remote.service.Success
import com.ricindigus.cambista.domain.Authentication
import com.ricindigus.cambista.modules.authentication.repository.IAuthenticationRepository
import com.ricindigus.cambista.utils.ConstantsUtils.Companion.EMPTY_STRING
import com.ricindigus.cambista.utils.ConstantsUtils.Companion.FALSE
import com.ricindigus.cambista.utils.ConstantsUtils.Companion.TRUE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class LoginViewModel(private val repository: IAuthenticationRepository): ViewModel(), KoinComponent{

    private val networkStatusChecker : NetworkStatusChecker by inject()

    private val _userValue = MutableLiveData<String>(EMPTY_STRING)
    fun getUserValue(): MutableLiveData<String> = _userValue

    private val _passwordValue = MutableLiveData<String>(EMPTY_STRING)
    fun getPasswordValue(): MutableLiveData<String> = _passwordValue

    private val _initSession = MutableLiveData<Boolean>()
    val initSession: LiveData<Boolean>
        get() = _initSession

    private val _enableContinueButton = MutableLiveData<Boolean>(FALSE)
    val enableContinueButton: LiveData<Boolean>
        get() = _enableContinueButton

    private val _showError = MutableLiveData<Boolean>(FALSE)
    val showError: LiveData<Boolean>
        get() = _showError

    private val _showLoading = MutableLiveData<Boolean>(FALSE)
    val showLoading: LiveData<Boolean>
        get() = _showLoading

    fun attemptLogin(){
        val authentication = Authentication(_userValue.value!!, _passwordValue.value!!)
        networkStatusChecker.performIfConnectedToInternet {
            GlobalScope.launch(Dispatchers.Main) {
                _showLoading.postValue(TRUE)
                when(val result = repository.onInitSession(authentication)){
                    is Success ->{
                        _initSession.postValue(TRUE)
                    }
                    is Failure -> {
                        _showError.postValue(TRUE)
                    }
                }
                _showLoading.postValue(FALSE)
            }
        }
    }

    fun validateFields() {
        if (_userValue.value!!.isNotBlank() && _passwordValue.value!!.isNotEmpty()){
            _enableContinueButton.postValue(TRUE)
        }else{
            _enableContinueButton.postValue(FALSE)
        }
    }

    fun finishInitSessionProcess() {
        _initSession.postValue(FALSE)
    }

    fun showLoading() = _showLoading.postValue(TRUE)
    fun hideLoading() = _showLoading.postValue(FALSE)

    fun finishShowError() = _showError.postValue(FALSE)
}