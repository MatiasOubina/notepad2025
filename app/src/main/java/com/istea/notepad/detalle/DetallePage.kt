package com.istea.notepad.detalle

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.istea.notepad.Nota

//Sirve para conectar e instanciar  tanto el viewModel como el view

@Composable
fun DetallePage(
    navController: NavController,
    nota: Nota
){
    //instanciamos el viewModel
    val viewModel = viewModel {
        DetalleViewModel(
            nota = nota,
            navController = navController
        )
    }

    //Pasamos el estado y la intención a la view (viewModel.estado)
    DetalleView(
        Modifier,
        estado = viewModel.estado,
    ) { intencion ->
        viewModel.ejecutar(intencion)
    }
}