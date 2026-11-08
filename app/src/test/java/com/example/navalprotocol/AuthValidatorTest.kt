package com.example.navalprotocol

import com.example.navalprotocol.util.AuthValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthValidatorTest {

    @Test
    fun `un correo con formato correcto es valido`() {
        assertTrue(AuthValidator.isValidEmail("capitan@flota.com"))
        assertFalse(AuthValidator.isValidEmail("capitan@flota"))
        assertFalse(AuthValidator.isValidEmail("capitanflota.com"))
    }

    @Test
    fun `login rechaza campos vacios y acepta datos correctos`() {
        assertNotNull(AuthValidator.validateLogin("", "123456"))
        assertNotNull(AuthValidator.validateLogin("a@b.com", ""))
        assertNull(AuthValidator.validateLogin("a@b.com", "123456"))
    }

    @Test
    fun `registro exige nombre, correo, contrasena larga y confirmacion igual`() {
        assertNotNull(AuthValidator.validateRegister("ab", "a@b.com", "123456", "123456"))
        assertNotNull(AuthValidator.validateRegister("kevin", "malo", "123456", "123456"))
        assertNotNull(AuthValidator.validateRegister("kevin", "a@b.com", "123", "123"))
        assertNotNull(AuthValidator.validateRegister("kevin", "a@b.com", "123456", "654321"))
        assertNull(AuthValidator.validateRegister("kevin", "a@b.com", "123456", "123456"))
    }
}