package vwg.skoda.bf.screen.matrix

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import vwg.skoda.bf.holders.ColorMatrixHolder
import androidx.compose.ui.graphics.ColorFilter
import vwg.skoda.bf.R
import vwg.skoda.bf.holders.SysSetHolder


var preset1: List<Float> =  listOf(
    .8f, .05f,  .05f, 1f,
    0f, .025f,  0f, 1f,
    0f, 0f,  .025f, 1f,
    0f, 0f,  1f, 0f
)

@Composable
fun Matrix() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Column (
            modifier = Modifier
                .weight(2f)
        ) {
            HorizontalDivider(thickness = 1.dp)

            // Red (red)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "RED", color = Color.Red)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    val test: SliderColors = SliderColors(
//                        activeTrackColor = Color.Red,
//                        activeTickColor = Color.Red,
//                        inactiveTrackColor = Color.Red,
//                        inactiveTickColor = Color.Red,
//                        disabledThumbColor = Color.Red,
//                        disabledActiveTrackColor = Color.Red,
//                        disabledActiveTickColor = Color.Red,
//                        disabledInactiveTrackColor = Color.Red,
//                        disabledInactiveTickColor = Color.Red
//                    )

                    Slider(
                        value = ColorMatrixHolder.getElement(0, 0),
                        onValueChange = { ColorMatrixHolder.setElement(0, 0, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color.Red,
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text =  ColorMatrixHolder.getElement(0, 0).toString(), color = Color.White)
                }
            }

            // Red (green)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "GREEN", color = Color.Red)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = ColorMatrixHolder.getElement(1),
                        onValueChange = { ColorMatrixHolder.setElement(1, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(0xffffbd00),
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = ColorMatrixHolder.getElement(1).toString(), color = Color.White)
                }
            }

            // Red (blue)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "BLUE", color = Color.Red)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = ColorMatrixHolder.getElement(2),
                        onValueChange = { ColorMatrixHolder.setElement(2, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(0xffff00bd),
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = ColorMatrixHolder.getElement(2).toString(), color = Color.White)
                }
            }

            HorizontalDivider(thickness = 1.dp)

            // Green (red)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "RED", color = Color.Green)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = ColorMatrixHolder.getElement(5),
                        onValueChange = { ColorMatrixHolder.setElement(5, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(0xffbdff00),
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = ColorMatrixHolder.getElement(5).toString(), color = Color.White)
                }
            }

            // Green (green)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "GREEN", color = Color.Green)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = ColorMatrixHolder.getElement(1, 1),
                        onValueChange = { ColorMatrixHolder.setElement(1, 1, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color.Green,
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = ColorMatrixHolder.getElement(1, 1).toString(), color = Color.White)
                }
            }

            // Green (blue)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "BLUE", color = Color.Green)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = ColorMatrixHolder.getElement(7),
                        onValueChange = { ColorMatrixHolder.setElement(7, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(0xff00ffbd),
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = ColorMatrixHolder.getElement(7).toString(), color = Color.White)
                }
            }
            HorizontalDivider(thickness = 1.dp)

            // Blue (red)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "RED", color = Color.Blue)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = ColorMatrixHolder.getElement(10),
                        onValueChange = { ColorMatrixHolder.setElement(10, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(0xffbd00ff),
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = ColorMatrixHolder.getElement(10).toString(), color = Color.White)
                }
            }

            // Blue (green)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "GREEN", color = Color.Blue)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = ColorMatrixHolder.getElement(11),
                        onValueChange = { ColorMatrixHolder.setElement(11, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(0xff00bdff),
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = ColorMatrixHolder.getElement(11).toString(), color = Color.White)
                }
            }

            // Blue (blue)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "BLUE", color = Color.Blue)
                }
                Column(
                    modifier = Modifier
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = ColorMatrixHolder.getElement(2, 2),
                        onValueChange = { ColorMatrixHolder.setElement(2, 2, it) },
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color.Blue,
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = ColorMatrixHolder.getElement(2, 2).toString(), color = Color.White)
                }
            }
            HorizontalDivider(thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0 until 8) {
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            ColorMatrixHolder.preSet(i)
                        }) {
                            Text("Preset ".plus(i))
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Image (
                painter = painterResource(id = R.drawable.cw01),
                contentDescription = "Color Wheel",
                modifier = Modifier
//                    .fillMaxSize()
                    .clip(CircleShape),
                colorFilter = ColorFilter.colorMatrix(
                    ColorMatrixHolder.asColorMatrix()
                )
            )
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
    Matrix()
}