package com.example.columnapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End,
        content = { padding ->
            Content(modifier = Modifier.padding(padding))
        }
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "En el dia mas brillante...", Toast.LENGTH_SHORT).show()
        },
        containerColor = Color(0xFF006400)
    ) {
        Text(
            text = "ꗞ",
            color = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(
                text = "Prowler Profile",
                color = colorResource(id = R.color.white)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.background)
        )
    )
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF50C878))
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo AristiDevs",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Text(
                text = "Prowler",
                color = Color.White,
                fontSize = 32.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Aplicacion",
                color = Color.White,
                fontSize = 32.sp
            )
            Text(
                text = "Hola",
                color = Color.White,
                fontSize = 32.sp
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                item {
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                    Text(text = "Mogo ")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ViewContainer()
}