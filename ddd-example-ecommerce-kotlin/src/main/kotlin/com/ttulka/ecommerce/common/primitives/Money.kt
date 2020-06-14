package com.ttulka.ecommerce.common.primitives

/**
 * Money domain primitive.
 */
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

    fun value(): Float = money

    operator fun plus(summand: Money) = Money(money + summand.value())

    operator fun times(factor: Int) = Money(money * factor)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Money
        return money == other.money
    }

    override fun hashCode() = money.hashCode()

    override fun toString() = "Money(money=$money)"
}