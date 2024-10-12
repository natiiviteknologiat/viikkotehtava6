package com.example.viikkotehtava6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viikkotehtava6.ui.theme.Viikkotehtava6Theme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Viikkotehtava6Theme {
                ScaffoldApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldApp() {
    Scaffold(
        topBar = {
            MyTopBar()
        },
        content = { paddingValues ->
            Text(
                text = "Content for Home screen",
                modifier = Modifier.padding(paddingValues)
            )
        }
        // BottomBar is commented out since we do not want to display it anymore
        // bottomBar = {
        //     BottomAppBar {
        //         Text(text = "Bottom bar")
        //     }
        // }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(text = "My App")
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {
                expanded = !expanded
            }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                DropdownMenuItem(
                    text = { Text("Info") },
                    onClick = { /* TODO */ }
                )
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { /* TODO */ }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Viikkotehtava6Theme {
        ScaffoldApp()
    }
}
