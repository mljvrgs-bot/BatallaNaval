package com.example.navalprotocol.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navalprotocol.util.AuthValidator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/** Estado de las pantallas de acceso: cargando y mensaje de error. */
data class AuthUiState(val loading: Boolean = false, val error: String? = null)

/**
 * Puente entre Login/Registro y la autenticacion.
 * En este avance NO hay back: se validan los datos y se simula la espera.
 * TODO (siguiente avance): reemplazar la simulacion por Firebase Authentication.
 */
class AuthViewModel : ViewModel() {

    // Estado privado y mutable; la pantalla solo ve la version de solo lectura.
    private val _ui = MutableStateFlow(AuthUiState())
    val ui: StateFlow<AuthUiState> = _ui.asStateFlow()

    fun signIn(email: String, password: String, onSuccess: () -> Unit) {
        val error = AuthValidator.validateLogin(email, password)
        if (error != null) {
            _ui.value = AuthUiState(error = error)
            return
        }
        simulateRequest(onSuccess)
    }

    fun register(
        username: String,
        email: String,
        password: String,
        confirm: String,
        onSuccess: () -> Unit
    ) {
        val error = AuthValidator.validateRegister(username, email, password, confirm)
        if (error != null) {
            _ui.value = AuthUiState(error = error)
            return
        }
        simulateRequest(onSuccess)
    }

    /** Limpia el error al cambiar de pantalla (login <-> registro). */
    fun clearError() {
        _ui.value = AuthUiState()
    }

    // Espera corta para poder ver el estado "cargando" mientras no existe el servicio real.
    private fun simulateRequest(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _ui.value = AuthUiState(loading = true)
            delay(600)
            _ui.value = AuthUiState()
            onSuccess()
        }
    }
}