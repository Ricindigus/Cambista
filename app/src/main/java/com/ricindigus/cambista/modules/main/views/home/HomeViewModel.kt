package com.ricindigus.cambista.modules.main.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ricindigus.cambista.modules.main.repository.IHomeRepository
import com.ricindigus.cambista.utils.ConstantsUtils.Companion.EMPTY_STRING

class HomeViewModel(private val repository: IHomeRepository): ViewModel() {
    private val _userMail = MutableLiveData<String>(EMPTY_STRING)
    val userMail: LiveData<String>
        get() = _userMail


    init {
        _userMail.postValue(repository.readUser())
    }
}