package jambda.camp.clean.adapter.controller

import jambda.camp.clean.domain.OrderPosition

internal data class OrderPositionDto (
    val amount: Long,
    val productName: String
) {
    companion object {
        fun fromDomain(orderPosition: OrderPosition) = OrderPositionDto(
            amount = orderPosition.amount,
            productName = orderPosition.product.name.value
        )
    }
}

