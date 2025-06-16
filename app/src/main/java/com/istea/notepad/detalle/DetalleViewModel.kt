package com.istea.notepad.detalle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.istea.notepad.Nota
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//TODOS los ViewModel van a tener un estado (variable observada) y una función ejecutar

class DetalleViewModel(
    val nota: Nota,
    val navController: NavController? = null
): ViewModel(){

    var estado by mutableStateOf<DetalleEstado>(DetalleEstado.Vacio) //Variable observada

    //recibe la intención
    fun ejecutar(intencion: DetalleIntencion){
        when(intencion){
            DetalleIntencion.IrParaAtras -> irParaAtras()
            DetalleIntencion.CargarContenido -> cargarContenido()
        }
    }

    private fun irParaAtras() {
        navController?.popBackStack()
    }

    private fun cargarContenido(){
        estado = DetalleEstado.Cargando
        viewModelScope.launch {
            delay(2000)
            estado = DetalleEstado.Resultado(nota)
        }
    }
}