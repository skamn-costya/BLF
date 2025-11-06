//package vwg.skoda.bf.screen
//
//var showTimePicker by remember { mutableStateOf(false) }
//val state = rememberTimePickerState()
//val formatter = remember { SimpleDateFormat("hh:mm a", Locale.getDefault()) }
//val snackState = remember { SnackbarHostState() }
//val snackScope = rememberCoroutineScope()
//
//Box(propagateMinConstraints = false) {
//    Button(modifier = Modifier.align(Alignment.Center), onClick = { showTimePicker = true }) {
//        Text("Set Time")
//    }
//    SnackbarHost(hostState = snackState)
//}
//
//if (showTimePicker) {
//    TimePickerDialog(
//        title = { TimePickerDialogDefaults.Title(displayMode = TimePickerDisplayMode.Picker) },
//        onDismissRequest = { showTimePicker = false },
//        confirmButton = {
//            TextButton(
//                onClick = {
//                    val cal = Calendar.getInstance()
//                    cal.set(Calendar.HOUR_OF_DAY, state.hour)
//                    cal.set(Calendar.MINUTE, state.minute)
//                    cal.isLenient = false
//                    snackScope.launch {
//                        snackState.showSnackbar("Entered time: ${formatter.format(cal.time)}")
//                    }
//                    showTimePicker = false
//                }
//            ) {
//                Text("Ok")
//            }
//        },
//        dismissButton = { TextButton(onClick = { showTimePicker = false }) { Text("Cancel") } },
//        modeToggleButton = {},
//    ) {
//        TimePicker(state = state)
//    }
//}