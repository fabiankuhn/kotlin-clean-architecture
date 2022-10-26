package jambda.camp.clean.adapter.controller

import java.time.Instant

internal data class OrderDto (
    val orderDate: Instant,
    val totalPrice: Double,
    val orderPosition: List<OrderPositionDto>
)

