package vwg.skoda.bf.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vwg.skoda.bf.screen.matrix.Matrix
import vwg.skoda.bf.screen.night_shift.NightShift
import vwg.skoda.bf.screen.blue_light_filter.BlueLightFilter
import vwg.skoda.bf.screen.preview.Preview

@Composable
fun RootScreen() {
    var currentScreen by remember { mutableStateOf("night_shift") }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(16.dp),horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { currentScreen = "night_shift" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF78FAAE),    // зелёный Škoda
                    contentColor = Color.White             // цвет текста
                )
            ) { Text("Night Shift", color = Color(0xFF0E3A2F)) }
            Button(
                onClick = { currentScreen = "blue_light_filter" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF78FAAE),    // зелёный Škoda
                    contentColor = Color.White             // цвет текста
                )
            ) { Text("Blue Light Filter", color = Color(0xFF0E3A2F)) }
            Button(
                onClick = { currentScreen = "matrix" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF78FAAE),    // зелёный Škoda
                    contentColor = Color.White             // цвет текста
                )
            ) { Text("Matrix", color = Color(0xFF0E3A2F)) }
            Button(
                onClick = { currentScreen = "preview" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF78FAAE),    // зелёный Škoda
                    contentColor = Color.White             // цвет текста
                )
            ) { Text("Preview", color = Color(0xFF0E3A2F)) }
            /*
                «Emerald Green» — тёмно-зелёный: Hex #0E3A2F, RGB (14, 58, 47)
                «Electric Green» — ярко-зелёный: Hex #78FAAE, RGB (120, 250, 174)
             */
        }
        when (currentScreen) {
            "blue_light_filter" -> BlueLightFilter()
            "night_shift" -> NightShift()
            "matrix" -> Matrix()
            "preview" -> Preview()
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