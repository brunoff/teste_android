package br.com.bruno.fonseca.app.features.product

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.bruno.fonseca.app.data.remote.products.ProductResponseCashDTO
import br.com.bruno.fonseca.app.data.remote.products.ProductResponseSkuDTO
import br.com.bruno.fonseca.app.data.remote.products.ProductResponseSpotlightDTO
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProductViewModel(
    private val repository: ProductRepository,
    coroutineContext: CoroutineContext
) : ViewModel(),
    LifecycleObserver {

    val isLoading = MutableLiveData(false)
    var products = MutableLiveData<List<ProductResponseSkuDTO>>(listOf())
    var spotlight = MutableLiveData<List<ProductResponseSpotlightDTO>>(listOf())
    var cash = MutableLiveData<ProductResponseCashDTO?>()

    init {
        isLoading.postValue(true)
        viewModelScope.launch(coroutineContext) {
            try {
                val product = repository.get()
                products.postValue(product.products)
                spotlight.postValue(product.spotlight)
                cash.postValue(product.cash)
            } catch (t: Throwable) {
                t.printStackTrace()
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}