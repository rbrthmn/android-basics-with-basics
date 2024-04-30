package com.example.androidbasics.unit4.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.androidbasics.data.Datasource
import com.example.androidbasics.unit4.ui.states.DessertUiState
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    private val desserts = Datasource.dessertList

    private lateinit var currentDessert: Dessert

    // verificar se faz sentido esse codigo
    init {
        openDessertsShop()
    }

    private fun openDessertsShop() {
        _uiState.value = DessertUiState(currentDessertImageId = desserts.first().imageId)
        currentDessert = determineDessertToShow(desserts)
    }

    fun updateSoldDesserts() {
        _uiState.update { currentState ->
            currentState.copy(
                totalRevenue = currentState.totalRevenue + currentDessert.price,
                dessertsSold = currentState.dessertsSold.inc())
        }

        val dessertToShow = determineDessertToShow(desserts)
        _uiState.update { currentState ->
            currentState.copy(
                currentDessertImageId = dessertToShow.imageId)
        }
    }

    private fun determineDessertToShow(
        desserts: List<Dessert>,
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (_uiState.value.dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }

        return dessertToShow
    }
}