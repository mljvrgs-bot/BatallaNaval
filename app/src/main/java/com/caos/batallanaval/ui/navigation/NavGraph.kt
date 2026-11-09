package com.caos.batallanaval.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.caos.batallanaval.ui.screens.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onStartGame = { navController.navigate(Routes.GAME_MODE) },
                onHowToPlay = { navController.navigate(Routes.HOW_TO_PLAY) }
            )
        }
        composable(Routes.HOW_TO_PLAY) {
            HowToPlayScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.GAME_MODE) {
            GameModeScreen(
                onSelectLocal = { navController.navigate(Routes.SHIP_PLACEMENT) },
                onSelectOnline = { navController.navigate(Routes.INVITE_CODE) }
            )
        }
        composable(Routes.INVITE_CODE) {
            InviteCodeScreen(
                onConnected = { navController.navigate(Routes.SHIP_PLACEMENT) }
            )
        }
        composable(Routes.SHIP_PLACEMENT) {
            ShipPlacementScreen(
                onPlacementComplete = { navController.navigate(Routes.BATTLE) }
            )
        }
        composable(Routes.BATTLE) {
            BattleScreen(
                onTriggerNewLife = { navController.navigate(Routes.NEW_LIFE) },
                onGameOver = { navController.navigate(Routes.RESULT) }
            )
        }
        composable(Routes.NEW_LIFE) {
            NewLifeScreen(
                recoveredShipName = "Último Barco Destruido",
                onAcceptMechanic = { navController.navigate(Routes.SHIP_PLACEMENT) },
                onDecline = { navController.navigate(Routes.RESULT) }
            )
        }
        composable(Routes.RESULT) {
            ResultScreen(
                onPlayAgain = { navController.navigate(Routes.GAME_MODE) },
                onHome = { navController.navigate(Routes.HOME) }
            )
        }
    }
}