package br.com.bruno.fonseca.app.sl

import br.com.bruno.fonseca.app.features.product.ProductRepository
import org.koin.dsl.module

val repositoryModules = module {
    factory { ProductRepository(get()) }
}