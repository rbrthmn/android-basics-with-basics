package com.example.androidbasics.unit2

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun `calculate tip with 20 percent and no round up should return correct value`(){
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip =  TipCalculator().calculateTip(amount = amount, tipPercent = tipPercent, false)

        assertEquals(expectedTip, actualTip)
    }
}