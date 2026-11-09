package com.caos.batallanaval.data.remote.firebase

class FirebaseLobbyService {
    // Preparado para la integración con Firebase Realtime Database
    suspend fun createRoomCode(): String {
        return (100000..999999).random().toString()
    }

    suspend fun validateRoomCode(code: String): Boolean {
        return code.length == 6
    }
}