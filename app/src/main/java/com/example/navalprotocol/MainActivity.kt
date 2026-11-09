package com.example.navalprotocol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.navalprotocol.ui.navigation.NavalNavGraph
import com.example.navalprotocol.ui.theme.NavalTheme

/** Unica actividad: aloja el tema y el grafo de navegacion. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavalTheme { NavalNavGraph() }
        }
    }
}