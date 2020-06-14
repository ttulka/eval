package com.ttulka.ecommerce.common.primitives

import lombok.EqualsAndHashCode
import lombok.ToString

/**
 * Quantity domain primitive.
 */
@EqualsAndHashCode
@ToString
class Quantity(quantity: Int) {

    companion object {
        val ZERO = Quantity(0)
        val ONE = Quantity(1)
    }

    private val quantity: Int

    init {
        require(quantity >= 0) { "Quantity cannot be less than zero!" }
        this.quantity = quantity
    }

    fun value(): Int = quantity

    fun add(addend: Quantity) = Quantity(quantity + addend.value())
}