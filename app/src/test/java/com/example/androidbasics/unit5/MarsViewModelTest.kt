package com.example.androidbasics.unit5

import com.example.androidbasics.unit5.domain.viewmodels.MarsViewModel
import com.example.androidbasics.unit5.fake.FakeDataSource
import com.example.androidbasics.unit5.fake.FakeNetworkMarsPhotosRepository
import com.example.androidbasics.unit5.rules.TestDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest {
        val viewModel = MarsViewModel(
            repository = FakeNetworkMarsPhotosRepository()
        )

        assertEquals(
            MarsViewModel.MarsUiState.Success(FakeDataSource.photosList),
            viewModel.marsUiState
        )
    }
}
