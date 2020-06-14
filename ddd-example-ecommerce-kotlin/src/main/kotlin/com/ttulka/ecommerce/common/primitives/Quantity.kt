package com.ttulka.ecommerce.common.primitives

/**
 * Quantity domain primitive.
 */
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

    operator fun plus(addend: Quantity) = Quantity(quantity + addend.value())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Quantity
        return quantity == other.quantity
    }

    override fun hashCode() = quantity.hashCode()

    override fun toString() = "Quantity(quantity=$quantity)"
}