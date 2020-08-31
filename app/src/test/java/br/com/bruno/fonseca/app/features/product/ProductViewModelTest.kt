package br.com.bruno.fonseca.app.features.product

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.bruno.fonseca.app.data.remote.products.ProductResponseCashDTO
import br.com.bruno.fonseca.app.data.remote.products.ProductResponseDTO
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test

class ProductViewModelTest {

    @get:Rule
    val scope = CoroutineTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `check values in livedata`() {
        val loginRepository = mockk<ProductRepository>()
        val mockValue = ProductResponseDTO(
            listOf(),
            listOf(),
            ProductResponseCashDTO("mockTitle", "mockUrl", "mockDescr")
        )

        coEvery { loginRepository.get() } returns mockValue
        val productViewModel = ProductViewModel(loginRepository, Dispatchers.Main)

        assertEquals(mockValue.cash, productViewModel.cash.value)
        assertEquals(mockValue.spotlight, productViewModel.spotlight.value)
        assertEquals(mockValue.products, productViewModel.products.value)
        assertFalse(productViewModel.isLoading.value!!)
    }
}