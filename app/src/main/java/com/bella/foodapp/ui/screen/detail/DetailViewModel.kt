package com.bella.foodapp.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bella.foodapp.data.FoodRepository
import com.bella.foodapp.model.SelectFood
import com.bella.foodapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel (private val repository: FoodRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<SelectFood>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<SelectFood>>
        get() = _uiState

    fun getFoodById(foodId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getSelectFoodById(foodId))
        }
    }
}