package jambda.camp.clean.use_casees.ports

import jambda.camp.clean.domain.Order

interface OrderRepository {
    fun save(order: Order): Order
}
