package vwg.skoda.bf.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.material3.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vwg.skoda.bf.screen.matrix.Matrix
import vwg.skoda.bf.screen.system.System
import vwg.skoda.bf.screen.preview.Preview

@Composable
fun RootScreen() {
    var currentScreen by remember { mutableStateOf("system") }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(16.dp),horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { currentScreen = "system" }) { Text("System") }
            Button(onClick = { currentScreen = "matrix" }) { Text("Matrix") }
            Button(onClick = { currentScreen = "preview" }) { Text("Preview") }
        }
        when (currentScreen) {
            "matrix" -> Matrix()
            "preview" -> Preview()
            "system" -> System()
        }
    }
}

@Preview(
    showBackground = true,
    device = "spec:width=1408dp,height=792dp,dpi=160",
    name = "AAOS 1408x792 Preview"
)
@Composable
fun PreviewRootScreen() {
    RootScreen()
}