package com.codely.shared.domain.valueObject

abstract class StringValueObject(protected val value: String) {
    override fun toString(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        return value == (other as StringValueObject).value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}