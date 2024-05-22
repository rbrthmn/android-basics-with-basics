package com.example.androidbasics.unit4

import com.example.androidbasics.unit3.data.Datasource
import com.example.androidbasics.unit4.ui.viewmodels.DessertClickerViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DessertClickerViewModelTest {
    private val viewModel = DessertClickerViewModel()

    @Test
    fun `updateSoldDesserts with opened shop should initialize ui state with default values`() {
        viewModel.openDessertsShop()

        assertEquals(FIRST_IMAGE_ID, viewModel.uiState.value.currentDessertImageId)
    }

    @Test
    fun `updateSoldDesserts with one dessert sold should update revenue and desserts sold`() {
        viewModel.updateSoldDesserts()

        assertEquals(REVENUE_AFTER_FIRST_SALE, viewModel.uiState.value.totalRevenue)
        assertEquals(SOLD_DESSERTS_AFTER_FIRST_SALE, viewModel.uiState.value.dessertsSold)
    }

    @Test
    fun `updateSoldDesserts with 5 dessert sold should update revenue and desserts sold`() {
        viewModel.updateSoldDesserts()

        assertEquals(REVENUE_AFTER_FIRST_SALE, viewModel.uiState.value.totalRevenue)
        assertEquals(SOLD_DESSERTS_AFTER_FIRST_SALE, viewModel.uiState.value.dessertsSold)
    }

    private companion object {
        val FIRST_IMAGE_ID = Datasource.dessertList.first().imageId
        const val REVENUE_AFTER_FIRST_SALE = 5
        const val SOLD_DESSERTS_AFTER_FIRST_SALE = 1
    }
}