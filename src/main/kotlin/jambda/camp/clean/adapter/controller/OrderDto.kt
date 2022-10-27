package jambda.camp.clean.adapter.controller

import jambda.camp.clean.domain.Order
import java.time.Instant

internal data class OrderDto (
    val orderDate: Instant,
    val totalPrice: Double,
    val orderPosition: List<OrderPositionDto>
) {
    companion object {
        fun fromDomain(order: Order) = OrderDto(
            orderDate = order.orderDate.value,
            totalPrice = order.totalPrice.value,
            orderPosition = order.positions.map { OrderPositionDto.fromDomain(it) }
        )
    }
}
