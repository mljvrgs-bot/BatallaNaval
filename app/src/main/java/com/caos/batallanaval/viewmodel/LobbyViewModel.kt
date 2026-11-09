package com.caos.batallanaval.viewmodel

import androidx.lifecycle.ViewModel
import com.caos.batallanaval.data.repository.OnlineLobbyRepositoryImpl
import com.caos.batallanaval.domain.repository.OnlineLobbyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LobbyViewModel(
    private val lobbyRepository: OnlineLobbyRepository = OnlineLobbyRepositoryImpl()
) : ViewModel() {

    private val _roomCode = MutableStateFlow("")
    val roomCode: StateFlow<String> = _roomCode

    private val _isWaitingOpponent = MutableStateFlow(false)
    val isWaitingOpponent: StateFlow<Boolean> = _isWaitingOpponent

    suspend fun createRoom(): String {
        val code = lobbyRepository.createRoom()
        _roomCode.value = code
        _isWaitingOpponent.value = true
        return code
    }

    suspend fun joinRoom(code: String): Boolean {
        return lobbyRepository.joinRoom(code)
    }
}