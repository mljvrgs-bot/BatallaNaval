package com.caos.batallanaval.data.repository

import com.caos.batallanaval.data.remote.firebase.FirebaseLobbyService
import com.caos.batallanaval.domain.repository.OnlineLobbyRepository

class OnlineLobbyRepositoryImpl(
    private val firebaseLobbyService: FirebaseLobbyService = FirebaseLobbyService()
) : OnlineLobbyRepository {

    override suspend fun createRoom(): String {
        return firebaseLobbyService.createRoomCode()
    }

    override suspend fun joinRoom(code: String): Boolean {
        return firebaseLobbyService.validateRoomCode(code)
    }
}