package jambda.camp.clean.domain

import java.util.*

data class Order(
    val deliveryDate: OrderDeliveryDate
)

data class OrderDeliveryDate(
    val date: Date
)
