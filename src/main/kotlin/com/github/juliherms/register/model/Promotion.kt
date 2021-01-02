package com.github.juliherms.register.model

/**
 * This class responsible to represents promotion in the systems
 */
data class Promotion (
    val id: Long,
    val description: String,
    val quantityDays: Int,
    val discount: Double,
    val percentualDiscount: Double
)