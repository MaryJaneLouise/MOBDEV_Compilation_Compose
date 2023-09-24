package com.mariejuana.mobdevcompilationcompose.ui.screens.basics.odd_or_even

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState


class OddEvenViewModel : ViewModel() {
    val text = MutableLiveData<String>()

    fun updateText(newText: String) {
        text.value = newText
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OddOrEvenScreen(oddEvenViewModel: OddEvenViewModel = viewModel()) {
    var text by remember { mutableStateOf("") }

    val resultText by oddEvenViewModel.text.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,) {
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text("Enter a number") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            onClick = {
                try {
                    val number = text.toInt()
                    val result = if (number % 2 == 0) "even" else "odd"
                    oddEvenViewModel.updateText("$number is $result.")
                } catch (e: NumberFormatException) {
                    oddEvenViewModel.updateText("'$text' is not valid input. Please enter a valid number.")
                }
            }) {
            Text("Check number")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = resultText,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun OddEvenPreview() {
    OddOrEvenScreen()
}