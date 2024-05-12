package com.bella.foodapp.data

import com.bella.foodapp.model.Drink
import com.bella.foodapp.model.Food
import com.bella.foodapp.model.SelectDrink
import com.bella.foodapp.model.SelectFood
import com.bella.foodapp.model.dummyDrink
import com.bella.foodapp.model.dummyDrink2
import com.bella.foodapp.model.dummyFood
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class DrinkRepository {
    private val selectDrink = mutableListOf<SelectDrink>()

    init {
        if (selectDrink.isEmpty()) {
            dummyDrink.forEach {
                selectDrink.add(SelectDrink(it, drink2 = null))
            }
            dummyDrink2.forEach {
                selectDrink.add(SelectDrink(drink = null, it))
            }
        }
    }

    fun getDrinks(): List<Drink> {
        return dummyDrink
    }

    fun getAllDrinks(): Flow<List<SelectDrink>> {
        return flowOf(selectDrink)
    }

    fun getSelectDrinkById(drinkId: Long): SelectDrink {
        return selectDrink.first {
            it.drink2?.id == drinkId
        }
    }

    companion object {
        @Volatile
        private var instance: DrinkRepository? = null

        fun getInstance(): DrinkRepository =
            instance ?: synchronized(this) {
                DrinkRepository().apply {
                    instance = this
                }
            }
    }
}