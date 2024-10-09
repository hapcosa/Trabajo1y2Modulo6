package com.example.trabajo1modulo6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trabajo1modulo6.navigate.navManager
import com.example.trabajo1modulo6.repository.contactoRepository
import com.example.trabajo1modulo6.ui.theme.Trabajo1Modulo6Theme
import com.example.trabajo1modulo6.viewModel.contactoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Trabajo1Modulo6Theme {
                navManager(viewModelContacto)
            }
        }
    }
    private val viewModelContacto : contactoViewModel by viewModels()
}


