package com.bella.foodapp.di

import com.bella.foodapp.data.DrinkRepository
import com.bella.foodapp.data.FoodRepository

object Injection {
    fun provideRepository(): FoodRepository {
        return FoodRepository.getInstance()
    }

    fun provideDrinkRepository(): DrinkRepository {
        return DrinkRepository.getInstance();
    }
}