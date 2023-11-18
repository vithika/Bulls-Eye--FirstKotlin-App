package com.vithika.bullseye.Components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.vithika.bullseye.R

@Composable
fun ResultDialog(
    dialogTitle:Int,
    hideDialog: () -> Unit,
    onRoundIncrement:()->Unit,
    sliderValue:Int,
    points:Int,
    modifier: Modifier = Modifier

) {
    AlertDialog(onDismissRequest = {
        hideDialog()
        onRoundIncrement()
    }, confirmButton = {

        TextButton(onClick = { hideDialog()
        onRoundIncrement()}) {
            Text(stringResource(R.string.result_dialog_button_text))

        }
    },
        title = { Text(stringResource(id= dialogTitle)) },
        text = { Text(stringResource(
            R.string.result_dialogue_message,
            sliderValue,points)) }
           // text ={Text(text="The slider value is $sliderValue")}
    )
}


