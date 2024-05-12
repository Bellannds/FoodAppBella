package com.bella.foodapp.ui.screen.drink

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bella.foodapp.data.DrinkRepository
import com.bella.foodapp.data.FoodRepository
import com.bella.foodapp.model.SelectDrink
import com.bella.foodapp.model.SelectFood
import com.bella.foodapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DrinkViewModel(private val repository: DrinkRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<SelectDrink>>> = MutableStateFlow(UiState.Loading)
    private val _groupedDrinks = MutableStateFlow(
        repository.getDrinks()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )

    val uiState: StateFlow<UiState<List<SelectDrink>>>
        get() = _uiState

    fun getAllDrinks() {
        viewModelScope.launch {
            repository.getAllDrinks()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { selectFoods ->
                    _uiState.value = UiState.Success(selectFoods)
                }
        }
    }
}