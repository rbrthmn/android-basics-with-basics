/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androidbasics.unit4.data

import com.example.androidbasics.R
import com.example.dessertclicker.model.Dessert
import com.example.androidbasics.unit4.model.MenuItem.EntreeItem
import com.example.androidbasics.unit4.model.MenuItem.SideDishItem
import com.example.androidbasics.unit4.model.MenuItem.AccompanimentItem

object DataSource {
    val entreeMenuItems = listOf(
        EntreeItem(
            name = "Cauliflower",
            description = "Whole cauliflower, brined, roasted, and deep fried",
            price = 7.00,
        ),
        EntreeItem(
            name = "Three Bean Chili",
            description = "Black beans, red beans, kidney beans, slow cooked, topped with onion",
            price = 4.00,
        ),
        EntreeItem(
            name = "Mushroom Pasta",
            description = "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic " +
                    "and olive oil",
            price = 5.50,
        ),
        EntreeItem(
            name = "Spicy Black Bean Skillet",
            description = "Seasonal vegetables, black beans, house spice blend, served with " +
                    "avocado and quick pickled onions",
            price = 5.50,
        )
    )

    val sideDishMenuItems = listOf(
        SideDishItem(
            name = "Summer Salad",
            description = "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
            price = 2.50,
        ),
        SideDishItem(
            name = "Butternut Squash Soup",
            description = "Roasted butternut squash, roasted peppers, chili oil",
            price = 3.00,
        ),
        SideDishItem(
            name = "Spicy Potatoes",
            description = "Marble potatoes, roasted, and fried in house spice blend",
            price = 2.00,
        ),
        SideDishItem(
            name = "Coconut Rice",
            description = "Rice, coconut milk, lime, and sugar",
            price = 1.50,
        )
    )

    val accompanimentMenuItems = listOf(
        AccompanimentItem(
            name = "Lunch Roll",
            description = "Fresh baked roll made in house",
            price = 0.50,
        ),
        AccompanimentItem(
            name = "Mixed Berries",
            description = "Strawberries, blueberries, raspberries, and huckleberries",
            price = 1.00,
        ),
        AccompanimentItem(
            name = "Pickled Veggies",
            description = "Pickled cucumbers and carrots, made in house",
            price = 0.50,
        )
    )

    val flavors = listOf(
        R.string.vanilla,
        R.string.chocolate,
        R.string.red_velvet,
        R.string.salted_caramel,
        R.string.coffee
    )

    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),
        Pair(R.string.six_cupcakes, 6),
        Pair(R.string.twelve_cupcakes, 12)
    )

    val dessertList = listOf(
        Dessert(R.drawable.cupcake, 5, 0),
        Dessert(R.drawable.donut, 10, 5),
        Dessert(R.drawable.eclair, 15, 20),
        Dessert(R.drawable.froyo, 30, 50),
        Dessert(R.drawable.gingerbread, 50, 100),
        Dessert(R.drawable.honeycomb, 100, 200),
        Dessert(R.drawable.icecreamsandwich, 500, 500),
        Dessert(R.drawable.jellybean, 1000, 1000),
        Dessert(R.drawable.kitkat, 2000, 2000),
        Dessert(R.drawable.lollipop, 3000, 4000),
        Dessert(R.drawable.marshmallow, 4000, 8000),
        Dessert(R.drawable.nougat, 5000, 16000),
        Dessert(R.drawable.oreo, 6000, 20000)
    )
}
