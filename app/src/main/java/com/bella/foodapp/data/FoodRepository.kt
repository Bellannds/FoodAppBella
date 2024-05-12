package com.bella.foodapp.data

import com.bella.foodapp.model.Food
import com.bella.foodapp.model.SelectFood
import com.bella.foodapp.model.dummyFood
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FoodRepository {
    private val selectFood = mutableListOf<SelectFood>()

    init {
        if (selectFood.isEmpty()) {
            dummyFood.forEach {
                selectFood.add(SelectFood(it))
            }
        }
    }

    fun getFoods(): List<Food> {
        return dummyFood
    }

    fun getAllFoods(): Flow<List<SelectFood>> {
        return flowOf(selectFood)
    }

    fun getSelectFoodById(foodId: Long): SelectFood {
        return selectFood.first {
            it.food.id == foodId
        }
    }

    companion object {
        @Volatile
        private var instance: FoodRepository? = null

        fun getInstance(): FoodRepository =
            instance ?: synchronized(this) {
                FoodRepository().apply {
                    instance = this
                }
            }
    }
}