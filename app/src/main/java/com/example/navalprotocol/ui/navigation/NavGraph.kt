package com.example.navalprotocol.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navalprotocol.ui.screens.HomeScreen

/** Rutas de la app. Cada pantalla tiene un nombre unico. */
object Routes {
    // --- Cuenta y comunidad ---
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val PROFILE = "profile"
    const val LEADERBOARD = "leaderboard"
    const val SETTINGS = "settings"
    const val NOTIFICATIONS = "notifications"

    // --- Inicio (y, mas adelante, el flujo de juego) ---
    const val HOME = "home"
}

/** Grafo principal. Arranca en el login. */
@Composable
fun NavalNavGraph() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Routes.LOGIN) {

        // Rutas de cuenta y comunidad (definidas en AccountGraph.kt).
        accountGraph(nav)

        composable(Routes.HOME) {
            HomeScreen(
                // El flujo de juego se integra al unir las dos partes del avance.
                onStart = {},
                onHowToPlay = {},
                onProfile = { nav.navigate(Routes.PROFILE) },
                onLeaderboard = { nav.navigate(Routes.LEADERBOARD) },
                onSettings = { nav.navigate(Routes.SETTINGS) },
                onNotifications = { nav.navigate(Routes.NOTIFICATIONS) }
            )
        }
    }
}