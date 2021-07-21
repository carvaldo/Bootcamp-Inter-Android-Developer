package com.github.carvaldo.fimo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.carvaldo.fimo.App
import com.github.carvaldo.fimo.datasource.Data
import com.github.carvaldo.fimo.datasource.local.entity.ResultMovie
import com.github.carvaldo.fimo.datasource.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {
    private val searchRepository by lazy { MovieRepository( App.database) }

    fun searchAsync(query: String) = MutableLiveData<Data<List<ResultMovie>>>().apply {
        viewModelScope.launch(Dispatchers.IO) {
            this@apply.postValue(searchRepository.searchAsync(query))
        }
    }
}