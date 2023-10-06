package com.example.firstapiapplication.ui.detail

import androidx.coordinatorlayout.widget.CoordinatorLayout.DispatchChangeEvent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapiapplication.data.network.RetrofitHelper
import com.example.firstapiapplication.data.network.model.baseball.Body
import com.example.firstapiapplication.data.network.model.baseball.teamRoster.Roster
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetalViewModel : ViewModel() {
    private var retrofit = RetrofitHelper.getClient()

    private val _listBaseball = MutableLiveData<List<Roster>>()
    val listBaseball= _listBaseball
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData= _errorLiveData
    private val _stateLiveData = MutableLiveData<Boolean>()
    val stateLiveData = _stateLiveData

    fun getDetailTeam(id: String) {
        _stateLiveData.postValue(false)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = retrofit.getTeamRoster(id)
                if (response.isSuccessful){
                    val body = response.body()
                    body?.let {
                        _stateLiveData.postValue(false)
                        val data = body.body.roster
                        _listBaseball.postValue(data)
                    }
                }else{
                    _errorLiveData.postValue("Hay algun error")
                }
            } catch (e: Exception) {
                _errorLiveData.postValue("Error: ${e.message}")
            }
        }
    }
}