package com.ttulka.ecommerce.common.primitives

import lombok.EqualsAndHashCode
import lombok.ToString

/**
 * Money domain primitive.
 */
@EqualsAndHashCode
@ToString
class Money(money: Float) {

    companion object {
        val ZERO = Money(0f)
        private const val MAX_VALUE = 1000000f
    }

    private val money: Float

    init {
        require(money >= 0) { "Money cannot be less than zero." }
        require(money <= MAX_VALUE) { "Money cannot be greater than $MAX_VALUE." }
        this.money = money
    }

    fun add(summand: Money) = Money(money + summand.value())

    fun multi(factor: Int) = Money(money * factor)

    fun value(): Float = money
}