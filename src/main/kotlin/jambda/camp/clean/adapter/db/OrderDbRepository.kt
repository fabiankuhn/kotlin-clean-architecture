package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.*
import jambda.camp.clean.use_casees.ports.OrderRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

internal interface OrderCrudRepository : CrudRepository<OrderEntity, Long>

@Repository
internal class OrderDbRepository internal constructor(
    private val orderRepository: OrderCrudRepository
) : OrderRepository {

    override fun save(order: Order): Order = orderRepository
        .save(OrderEntity.fromDomain(order))
        .toDomain()
}
