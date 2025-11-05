package io.team2681.swiftspinmaster_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.team2681.swiftspinmaster_demo.ui.theme.SwiftSpinMasterdemoTheme
import io.team2681.swiftspinprogress.compose.SwiftSpinProgressView
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwiftSpinMasterdemoTheme {
                SwiftSpinProgressDemo()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwiftSpinProgressDemo() {
    var showProgress by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            TopAppBar(
                title = { Text("SwiftSpin Progress") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            SwiftSpinProgressView(
                isVisible = showProgress,
                spinnerBackgroundColor = MaterialTheme.colorScheme.surface,
                staticItemColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                dynamicItemColor = MaterialTheme.colorScheme.primary,
                backgroundOverlayColor = Color.Black.copy(alpha = 0.3f),
                spinnerContainerSize = 100.dp
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 24.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(onClick = { showProgress = true }) {
                    Text("Show Progress")
                }
            }
            LaunchedEffect(showProgress) {
                if (showProgress) {
                    delay(5000)
                    showProgress = false
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwiftSpinProgressDemoPreview() {
    SwiftSpinProgressDemo()
}