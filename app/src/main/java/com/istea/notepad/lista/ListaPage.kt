package com.istea.notepad.lista

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.istea.notepad.Nota

@Composable
fun ListaPage(
    navController: NavController,
    listaDeNotas: List<Nota>,
){
    //instanciamos el viewModel
    val viewModel = viewModel {
        ListaViewModel(
            navController = navController,
            listaDeNotas = listaDeNotas
        )
    }

    //Pasamos el estado y la intención a la view (viewModel.estado)
    ListaView(
        estado = viewModel.estado,
    ) { intencion ->
        viewModel.ejecutar(intencion)
    }
}