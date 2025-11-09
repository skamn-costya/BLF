package vwg.skoda.bf.screen.system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.TimePickerDialogDefaults
import androidx.compose.material3.TimePickerDisplayMode
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vwg.skoda.bf.holders.SysSetHolder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun System() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
    ){
        HorizontalDivider(thickness = 1.dp)
        Row(
            modifier = Modifier
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
//                horizontalAlignment =  Alignment.CenterHorizontally
            ) {
                Text("Enable:", fontSize = 20.sp, color = Color.White)
            }
            Column(
                modifier = Modifier
                    .weight(7f)
            ) {
                Switch(
                    checked = SysSetHolder.getEnable(),
                    onCheckedChange = {
                        SysSetHolder.setEnable(it)
                    }
                )
            }
        }

        val radioOptions = listOf("Always", "Sunset - Sunrise", "Manual")
        var selectedOption = radioOptions[SysSetHolder.getMode()]

        // Selection Mode
        HorizontalDivider(thickness = 1.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
//                horizontalAlignment =  Alignment.CenterHorizontally
            ) {
                Text(
                    "Select mode:",
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .selectableGroup()
            ) {
                Row () {
                    radioOptions.forEach { text ->
                        Row(
                            modifier = Modifier
                                .weight(1f)
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick =
                                        {
                                            SysSetHolder.setMode(radioOptions.indexOf(text))
//                                            selectedOption = radioOptions[SysSetHolder.getMode()]
                                        },
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column() {
                                RadioButton(
                                    selected = (text == selectedOption),
                                    onClick = null
                                )
                            }
                            Column() {
                                Text(
                                    text = text,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier
                                        .padding(start = 16.dp),
                                    color = Color.White,
                                )
                            }
                        }
                    }
                }
            }
        }

        var showTimePicker by remember { mutableStateOf(false) }
        val state = rememberTimePickerState()

        if (SysSetHolder.getMode() == 2) {
//            HorizontalDivider(thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(7f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "From:",
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .offset(x = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Button(
                        onClick = { showTimePicker = true }
                    ) {
                        Text(SysSetHolder.getFrom())
                    }
                    if (showTimePicker) {
                        TimePickerDialog(
                            title = { TimePickerDialogDefaults.Title(displayMode = TimePickerDisplayMode.Picker) },
                            onDismissRequest = { showTimePicker = false },
                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        SysSetHolder.setFrom("".plus(state.hour).plus(":").plus(state.minute))
                                        showTimePicker = false
                                    }
                                ) {
                                    Text("Ok")
                                }
                            },
                            dismissButton = { TextButton(onClick = { showTimePicker = false }) { Text("Cancel") } },
                            modeToggleButton = {},
                        ) {
                            TimePicker(state = state)
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Till:",
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .offset(x = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Button(
                        onClick = { showTimePicker = true }
                    ) {
                        Text(SysSetHolder.getTill())
                    }
                    if (showTimePicker) {
                        TimePickerDialog(
                            title = { TimePickerDialogDefaults.Title(displayMode = TimePickerDisplayMode.Picker) },
                            onDismissRequest = { showTimePicker = false },
                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        SysSetHolder.setTill("".plus(state.hour).plus(":").plus(state.minute))
                                        showTimePicker = false
                                    }
                                ) {
                                    Text("Ok")
                                }
                            },
                            dismissButton = { TextButton(onClick = { showTimePicker = false }) { Text("Cancel") } },
                            modeToggleButton = {},
                        ) {
                            TimePicker(state = state)
                        }
                    }
                }
            }
        }

        val presetOptions = listOf("*******", "******", "*****", "****", "***", "**", "*")
        val selectedPresetOption = SysSetHolder.getPreset()

        // Selection level (Matrix)
//        HorizontalDivider(thickness = 1.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
//                horizontalAlignment =  Alignment.CenterHorizontally
            ) {
                Text(
                    "Select level:",
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f)
            ) {
                SingleChoiceSegmentedButtonRow {
                    presetOptions.forEachIndexed { index, label ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = presetOptions.size,
                            ),
                            colors = SegmentedButtonDefaults.colors(
                                inactiveContentColor = Color.LightGray,
                                activeContentColor = Color.Red
                            ),
                            icon = {},
                            onClick = {
                                SysSetHolder.setPreset(index)
                            },
                            selected = (index == selectedPresetOption),
                            label = { Text(label) }
                        )
                    }
                }
            }
        }
        HorizontalDivider(thickness = 1.dp)
    }
}

@Preview(
    showBackground = true,
    device = "spec:width=1408dp,height=792dp,dpi=160",
    name = "AAOS 1024x768 Preview"
)
@Composable
fun PreviewInfoScreen() {
    System()
}