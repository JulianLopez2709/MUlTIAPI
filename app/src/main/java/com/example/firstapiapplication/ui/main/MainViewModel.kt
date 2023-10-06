package com.example.firstapiapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapiapplication.data.network.RetrofitHelper
import com.example.firstapiapplication.data.network.model.baseball.Body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private var  retrofit = RetrofitHelper.getClient()

    private val _listBaseball = MutableLiveData<List<Body>>()
    val listBaseball= _listBaseball
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData= _errorLiveData
    private val _stateLiveData = MutableLiveData<Boolean>()
    val stateLiveData = _stateLiveData

    fun getRetrofit(){
        viewModelScope.launch(Dispatchers.IO) {
            _stateLiveData.postValue(true)

            try {
                val response = retrofit.getTeams()
                if (response.isSuccessful){
                    val body = response.body()
                    body?.let {
                        _stateLiveData.postValue(false)
                        _listBaseball.postValue(it.body)
                    }
                }else{
                    errorLiveData.postValue("No se pudo conectar: ")
                }
            }catch (e:Exception){
                errorLiveData.postValue("Error: ${e.message}")
            }
        }
    }
}