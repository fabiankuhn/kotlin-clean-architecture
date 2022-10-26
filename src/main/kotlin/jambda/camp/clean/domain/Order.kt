package jambda.camp.clean.domain

import java.time.Instant

data class Order(
    val customerId: OrderCustomerId,
    val orderDate: OrderDate,
    val totalPrice: OrderPrice,
    val positions: List<OrderPosition>
)

data class OrderDate(
    val value: Instant
)

data class OrderCustomerId(
    val value: String
)

data class OrderPrice(
    val value: Double
)

data class OrderPosition(
    val amount: Long,
    val product: Product
)

