package com.example.viikkotehtava6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viikkotehtava6.ui.theme.Viikkotehtava6Theme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Viikkotehtava6Theme {
                val navController = rememberNavController()
                ScaffoldApp(navController)
            }
        }
    }
}

@Composable
fun ScaffoldApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            MainScreen(navController)
        }
        composable("Info") {
            InfoScreen(navController)
        }
        composable("Settings") {
            SettingsScreen(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "My App", navController = navController)
        },
        content = { paddingValues ->
            Text(
                text = "Content for Home screen",
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
fun InfoScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            ScreenTopBar(title = "Info", navController = navController)
        },
        content = { paddingValues ->
            Text(
                text = "Content for Info screen",
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
fun SettingsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            ScreenTopBar(title = "Settings", navController = navController)
        },
        content = { paddingValues ->
            Text(
                text = "Content for Settings screen",
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String, navController: NavHostController) {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Info") },
                    onClick = {
                        navController.navigate("Info")
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        navController.navigate("Settings")
                        expanded = false
                    }
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopBar(title: String, navController: NavHostController) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    Viikkotehtava6Theme {
        ScaffoldApp(navController)
    }
}