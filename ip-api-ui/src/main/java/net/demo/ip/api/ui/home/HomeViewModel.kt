package net.demo.ip.api.ui.home

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.demo.ip.api.ui.R
import net.demo.ip.api.ui.core.SingleLiveEvent
import java.util.regex.Pattern

class HomeViewModel : ViewModel() {
    val requestedIp = ObservableField<String>()
    val ipValidationError = ObservableInt()

    init {
        requestedIp.set("46.119.150.106")
    }
    private val _events = SingleLiveEvent<UiEvent>()
    val events: LiveData<UiEvent>
        get() = _events

    fun onIpChanged() {
        ipValidationError.set(0)
    }

    fun onNextClicked() {
        if (!isIpValid(requestedIp, ipValidationError)) {
            return
        }
        _events.value = UiEvent.OnNextClicked(requestedIp.get() ?: "")
    }

    sealed class UiEvent {
        data class OnNextClicked(val requestedIp: String) : UiEvent()
    }
}

private const val IP_REGEX =
    "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\$"

private fun ViewModel.isIpValid(
    ip: ObservableField<String>,
    onValidationError: ObservableInt
): Boolean {
    ip.get()?.let {
        val pattern = Pattern.compile(IP_REGEX)
        val matcher = pattern.matcher(it)
        val valid = matcher.matches()
        if (!valid) {
            onValidationError.set(R.string.ip_not_valid_error)
        }
        return valid
    }
    onValidationError.set(R.string.empty_field_error)
    return false
}