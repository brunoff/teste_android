package br.com.bruno.fonseca.app.sl

import br.com.bruno.fonseca.app.features.product.ProductViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val viewModelModule = module {
    factory { ProductViewModel(get(), Dispatchers.IO) }
}