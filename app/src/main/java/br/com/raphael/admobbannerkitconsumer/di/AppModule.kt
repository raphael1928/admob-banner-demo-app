package br.com.raphael.admobbannerkitconsumer.di

import br.com.raphael.admobbannerkitconsumer.model.MovieRepository
import br.com.raphael.admobbannerkitconsumer.presentation.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    //Extrair chave para Secrets
    single { MovieRepository(get(), apiKey = "6d3a870ff47b5dece1f0cb52c0de17cf") }
    // Atualizar para viewmodelOf
    viewModel { MovieViewModel(get()) }
}
