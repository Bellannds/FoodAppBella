package com.bella.foodapp.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bella.foodapp.data.FoodRepository
import com.bella.foodapp.model.SelectFood
import com.bella.foodapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: FoodRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<SelectFood>>> = MutableStateFlow(UiState.Loading)
    private val _query = mutableStateOf("")
    private val _groupedFoods = MutableStateFlow(
        repository.getFoods()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )

    val uiState: StateFlow<UiState<List<SelectFood>>>
        get() = _uiState
    val query: State<String>
        get() = _query

    fun getAllFoods() {
        viewModelScope.launch {
            repository.getAllFoods()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { selectFoods ->
                    _uiState.value = UiState.Success(selectFoods)
                }
        }
    }
}