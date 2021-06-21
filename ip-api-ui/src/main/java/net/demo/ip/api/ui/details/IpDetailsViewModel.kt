package net.demo.ip.api.ui.details

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.demo.ip.api.domain.ResultObj
import net.demo.ip.api.domain.usecase.GetIpDetailsUsecase

class IpDetailsViewModel(val ip: String, getIpDetailsUsecase: GetIpDetailsUsecase) : ViewModel() {
    val isLoading = ObservableBoolean()
    val ipDetails = ObservableField<String>()
    val errorMessage = ObservableField<String>()

    init {
        isLoading.set(true)
        viewModelScope.launch {
            val result = getIpDetailsUsecase.execute(ip)
            when (result) {
                is ResultObj.Success -> showDetails(result.data)
                is ResultObj.Error -> showError(result.exception.message)
            }
        }
    }

    private fun showError(message: String?) {
        if (message.isNullOrBlank()) {
            errorMessage.set("Unknown error")
        } else {
            errorMessage.set(message)
        }
        isLoading.set(false)
    }

    private fun showDetails(data: String) {
        ipDetails.set(data)
        isLoading.set(false)
    }
}