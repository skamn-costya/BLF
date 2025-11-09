package vwg.skoda.bf.screen.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import vwg.skoda.bf.R
import vwg.skoda.bf.screen.ColorMartixWraper

@Composable
fun Preview() {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (
            modifier = Modifier
                .weight(1f)
        ){
            Image(
//            painter = painterResource(id = R.drawable.apps),
                painter = painterResource(id = R.drawable.rgb),
                contentDescription = "Apps",
            )
        }
        Column (
            modifier = Modifier
                .weight(1f)
        ){
            ColorMartixWraper {
                Image(
//                    painter = painterResource(id = R.drawable.apps),
                    painter = painterResource(id = R.drawable.rgb),
                    contentDescription = "Apps",
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = "spec:width=1408dp,height=792dp,dpi=160",
    name = "AAOS 1024x768 Preview"
)
@Composable
fun PreviewInfoScreen() {
    Preview()
}