package br.com.raphael.admobbannerkitconsumer.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.raphael.admobbannerkitconsumer.model.MovieRepository
import br.com.raphael.admobbannerkitconsumer.model.MovieResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movie = MutableStateFlow<MovieResult?>(null)
    val movie: StateFlow<MovieResult?> get() = _movie

    fun loadMovie(title: String) {
        viewModelScope.launch {
            runCatching {
                repository.getMovie(title)
            }.onSuccess {
                _movie.value = it
            }.onFailure { e ->
                Log.e("MovieViewModel", "Erro ao buscar filme", e)
            }
        }
    }
}

