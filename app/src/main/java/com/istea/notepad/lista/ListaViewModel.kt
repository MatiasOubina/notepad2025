package com.istea.notepad.lista

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.istea.notepad.Nota

class ListaViewModel(
     val navController: NavController? = null,
    val listaDeNotas: List<Nota>
): ViewModel() {

    var estado by mutableStateOf<ListaEstado>(ListaEstado.Vacio) //Variable observada

    //recibe la intención
    fun ejecutar(intencion: ListaIntencion) {
        when(intencion){
            ListaIntencion.CargarLista -> CargarLista()
            is ListaIntencion.NotaSeleccionada -> NotaSeleccionada(intencion.nota)
            ListaIntencion.NuevaNota -> NuevaNota()
        }
    }

    fun CargarLista(){
        estado = ListaEstado.Resultado(listaDeNotas)
    }

    fun NotaSeleccionada(nota: Nota){
        navController?.navigate("detalle/${nota.titulo}")
    }

    fun NuevaNota(){
        navController?.navigate("nueva")
    }
}