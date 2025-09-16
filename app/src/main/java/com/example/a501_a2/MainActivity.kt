package com.example.a501_a2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a501_a2.ui.theme._501_A2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _501_A2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KotlinPracticeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun KotlinPracticeScreen(modifier: Modifier = Modifier) {
    // State variables
    var animalType by remember { mutableStateOf<String?>(null) }
    var nullableMessage by remember { mutableStateOf<String?>(null) }
    var counter by remember { mutableStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Title
        Text(
            text = "Kotlin Practice Screen",
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        // Section 1: When Expression
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Part 1",
                    style = MaterialTheme.typography.titleMedium
                )

                // TextField for user input
                OutlinedTextField(
                    value = animalType ?: "",
                    onValueChange = { animalType = it.lowercase() },
                    label = { Text("Enter animal type") },
                    placeholder = { Text("Try: cat, dog, fish, bird") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Using when expression to determine the message
                val animalSound = if (animalType != null) {
                    when(animalType?.lowercase()) {
                        "cat" -> "🐱"
                        "dog" -> "🐕"
                        "fish" -> "🐠"
                        "bird" -> "🐦"
                        "" -> "Type an animal name above"
                        else -> "Unknown animal"
                    }
                } else {
                    "Type an animal name above" // Or some other default for null
                }

                Text(
                    text = "$animalSound",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // Section 2: Nullable String with ?.let
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Part 2",
                    style = MaterialTheme.typography.titleMedium
                )

                // TextField for entering message
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = {
                        textFieldValue = it
                        nullableMessage = if (it.isNotEmpty()) it else null
                    },
                    label = { Text("Enter a message") },
                    placeholder = { Text("Type something here...") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Button to show pop-up
                Button(
                    onClick = {
                        // Using ?.let to show dialog only if message is not null
                        nullableMessage?.let { message ->
                            showDialog = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = nullableMessage != null
                ) {
                    Text("Echo")
                }
            }
        }

        // Dialog that shows when button is clicked (only if string is not null)
        if (showDialog) {
            nullableMessage?.let { message ->
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = {
                        Text(text = "Message Display")
                    },
                    text = {
                        Text(
                            text = "Your message:\n\n$message",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = { showDialog = false }
                        ) {
                            Text("OK")
                        }
                    }
                )
            }
        }

        // Section 3: Counter with condition
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "Part 3",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Counter: $counter",
                    style = MaterialTheme.typography.headlineLarge
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            // Only increment if below 5
                            if (counter < 5) {
                                counter++
                            }
                        },
                        enabled = counter < 5
                    ) {
                        Text("Increment")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KotlinPracticeScreenPreview() {
    _501_A2Theme {
        KotlinPracticeScreen()
    }
}