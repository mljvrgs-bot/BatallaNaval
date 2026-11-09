package com.example.navalprotocol.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navalprotocol.ui.screens.LeaderboardScreen
import com.example.navalprotocol.ui.screens.LoginScreen
import com.example.navalprotocol.ui.screens.NotificationsScreen
import com.example.navalprotocol.ui.screens.ProfileScreen
import com.example.navalprotocol.ui.screens.RegisterScreen
import com.example.navalprotocol.ui.screens.SettingsScreen

/**
 * Rutas de cuenta y comunidad. Vive en su propio archivo para que los dos
 * casi no editen los mismos archivos y se eviten conflictos de merge.
 */
fun NavGraphBuilder.accountGraph(nav: NavHostController) {

    composable(Routes.LOGIN) {
        LoginScreen(
            onSuccess = {
                // Se saca el login del historial: "atras" no debe volver a el.
                nav.navigate(Routes.HOME) { popUpTo(Routes.LOGIN) { inclusive = true } }
            },
            onGoRegister = { nav.navigate(Routes.REGISTER) }
        )
    }

    composable(Routes.REGISTER) {
        RegisterScreen(
            onSuccess = {
                nav.navigate(Routes.HOME) { popUpTo(Routes.LOGIN) { inclusive = true } }
            },
            onGoLogin = { nav.popBackStack() }
        )
    }

    composable(Routes.PROFILE) {
        ProfileScreen(
            onBack = { nav.popBackStack() },
            onSettings = { nav.navigate(Routes.SETTINGS) }
        )
    }

    composable(Routes.LEADERBOARD) { LeaderboardScreen(onBack = { nav.popBackStack() }) }

    composable(Routes.NOTIFICATIONS) { NotificationsScreen(onBack = { nav.popBackStack() }) }

    composable(Routes.SETTINGS) {
        SettingsScreen(
            onBack = { nav.popBackStack() },
            // Cerrar sesion: se limpia todo el historial y se vuelve al login.
            onSignOut = { nav.navigate(Routes.LOGIN) { popUpTo(0) { inclusive = true } } }
        )
    }
}