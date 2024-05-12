package com.bella.foodapp.ui.screen.drink

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bella.foodapp.R
import com.bella.foodapp.di.Injection
import com.bella.foodapp.model.SelectDrink
import com.bella.foodapp.ui.ViewDrinkModelFactory
import com.bella.foodapp.ui.common.UiState
import com.bella.foodapp.ui.components.DrinkItem
import com.bella.foodapp.ui.components.DrinkItem2
import com.bella.foodapp.ui.components.SectionText

@Composable
fun DrinkScreen(
    modifier: Modifier = Modifier,
    viewModel: DrinkViewModel = viewModel(
        factory = ViewDrinkModelFactory(Injection.provideDrinkRepository())
    ),

) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllDrinks()
            }
            is UiState.Success -> {
                Column(modifier = modifier.fillMaxSize()) {
                    DrinkSection(

                        content = {
                            DrinkContent(uiState.data) },
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DrinkSection(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        content()
    }
}

@Composable
fun DrinkContent(
    listDrink: List<SelectDrink>,
    modifier: Modifier = Modifier,

) {
    SectionText("Kategori Minuman", modifier = modifier)
    LazyRow (modifier = modifier, horizontalArrangement = Arrangement.spacedBy(20.dp)){
        items(listDrink) { it ->
            it.drink2?.let {drinks ->
                DrinkItem2(drinks, modifier = modifier)
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    SectionText("Rekomendasi", modifier = modifier)
    LazyColumn (modifier = modifier, verticalArrangement = Arrangement.spacedBy(20.dp)){
        items(listDrink) { it ->
            it.drink?.let {drinks ->
                DrinkItem(drinks, modifier = modifier)
            }
        }
    }
}