package com.example.scaffold_cafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scaffold_cafe.ui.theme.Scaffold_cafeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldCafeExample()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldCafeExample() {
    var cupsOfCoffee by remember { mutableIntStateOf(0) }
    val mainColor = Color(0xFF6F4F1F)
    val secondaryColor = Color(0xFFFAF3E0)
    val thirdColor = Color(0xFF2B2B2B)

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = mainColor,
                    titleContentColor = secondaryColor,
                ),
                title = {
                    Text("Scaffold Cafe", color = secondaryColor)
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = mainColor,
                contentColor = secondaryColor,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Feito com ❤️ e café!",
                    color = secondaryColor
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { cupsOfCoffee++ },
                containerColor = Color(0xFF228B22)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar café")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(secondaryColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                fontSize = 26.sp,
                text = """
                    Prepare-se para o café! 
                    Você já tomou sua xícara de café hoje? 
        
                    Xícaras tomadas: $cupsOfCoffee
                """.trimIndent(),
                color = thirdColor
            )
        }
    }
}
