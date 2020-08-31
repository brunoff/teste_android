package br.com.bruno.fonseca.app.sl

import br.com.bruno.fonseca.app.data.remote.products.ProductsApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideApiProducts(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://7hgi9vtkdc.execute-api.sa-east-1.amazonaws.com/sandbox/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .build()
}

fun provideApiProducts(retrofit: Retrofit): ProductsApiService =
    retrofit.create(ProductsApiService::class.java)