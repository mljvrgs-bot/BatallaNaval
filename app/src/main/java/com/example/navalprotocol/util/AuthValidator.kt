package com.example.navalprotocol.util

/**
 * Reglas de validacion de los formularios de acceso.
 * Cada funcion devuelve el mensaje de error, o null si los datos son validos.
 * Es logica pura: no depende de Android, por eso se prueba con JUnit simple.
 */
object AuthValidator {

    const val MIN_PASSWORD = 6
    const val MIN_USERNAME = 3

    // Formato basico: algo@algo.algo, sin espacios.
    private val emailRegex = Regex("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")

    fun isValidEmail(email: String): Boolean = emailRegex.matches(email.trim())

    fun validateLogin(email: String, password: String): String? = when {
        email.isBlank() || password.isBlank() -> "Ingresa el correo y la contrasena."
        !isValidEmail(email) -> "El correo no es valido."
        else -> null
    }

    fun validateRegister(username: String, email: String, password: String, confirm: String): String? = when {
        username.trim().length < MIN_USERNAME -> "El nombre debe tener al menos $MIN_USERNAME caracteres."
        !isValidEmail(email) -> "El correo no es valido."
        password.length < MIN_PASSWORD -> "La contrasena debe tener al menos $MIN_PASSWORD caracteres."
        password != confirm -> "Las contrasenas no coinciden."
        else -> null
    }
}