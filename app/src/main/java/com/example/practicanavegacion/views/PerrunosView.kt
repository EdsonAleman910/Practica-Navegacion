package com.example.practicanavegacion.views

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicanavegacion.R
import com.example.practicanavegacion.components.MainButton
import com.example.practicanavegacion.components.MainIconButton
import com.example.practicanavegacion.components.Space
import com.example.practicanavegacion.components.TitleBar
import com.example.practicanavegacion.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PerrunosView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail view") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentPerrunosView(navController)
    }
}

@Composable
fun ContentPerrunosView(navController: NavController) {
    val imagen = painterResource(id = R.drawable.perro)
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 88.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            var edad by remember { mutableStateOf(TextFieldValue("")) }
            var resul by remember { mutableStateOf("") } // Cambiar a String

            Text(
                text = "Calculadora de edad Perruna",
                fontSize = 40.sp,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text(text = "Ingresa la edad") }
            )

            ElevatedButton(
                onClick = {
                    // Convertir la edad a Int
                    val edadInt = edad.text.toIntOrNull()
                    if(edadInt == null){
                        //Toast.makeText(context, "Ta mal", Toast.LENGTH_SHORT)
                        val builder = AlertDialog.Builder(context)
                        builder.setTitle("ERROR!!")
                        builder.setMessage("Solo puedes ingresar numeros")
                        builder.setPositiveButton("OK", null)
                        builder.create()
                        builder.show()
                    }else {
                        val res = edadInt * 7
                        resul = res.toString() // Asignar como String
                    }
                }) {
                Text(text = "CALCULAR", textAlign = TextAlign.Center)
            }

            OutlinedTextField(
                value = resul, // Mostrar resultado
                readOnly = true,
                onValueChange = { },
                label = { Text(text = "Tu edad Perruna") }
            )
        }
    }
}

