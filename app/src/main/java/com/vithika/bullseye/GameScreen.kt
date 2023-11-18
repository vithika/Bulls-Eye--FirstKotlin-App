package com.vithika.bullseye


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vithika.bullseye.ui.theme.BullsEyeTheme
import java.lang.Math.abs
import kotlin.random.Random


@Composable
fun GameScreen() {
    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableStateOf(0.5f) }
    var targetValue by rememberSaveable { mutableStateOf(Random.nextInt(1,100)) }
    var sliderToInt = (sliderValue * 100).toInt()

   fun pointsForCurrentRound():Int
   {
       val maxScore=100
       val difference = abs(targetValue - sliderToInt)
       return  maxScore-difference
   }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(9f)
        ) {
            GamePrompt(targetValue =  targetValue)
            TargetSlider(value = sliderValue,
                valueChanged = { value ->
                    sliderValue = value
                })
            Button(onClick = {
                alertIsVisible = true;
            }) {
                Text(text = stringResource(R.string.hit_me))
            }
        }
        Spacer(modifier = Modifier.weight(.5f))
        if (alertIsVisible) {
            ResultDialog(hideDialog = {
                alertIsVisible = false
            }, sliderValue = sliderToInt,
                points = pointsForCurrentRound())
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    BullsEyeTheme {
        GameScreen()
    }
}