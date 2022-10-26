package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.*
import jambda.camp.clean.use_casees.ports.OrderRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

internal interface OrderCrudRepository : CrudRepository<OrderDto, String>

@Repository
internal class OrderDbRepository internal constructor(
    private val orderRepository: OrderCrudRepository
) : OrderRepository {

    override fun save(order: Order): Order = orderRepository
        .save(order.toDto())
        .toDomain()
}

private fun Order.toDto() = OrderDto(
    customerId = this.customerId.value,
    orderDate = this.orderDate.value,
    totalPrice = this.totalPrice.value,
    positions = this.positions.map { it.toDto() }
)

private fun OrderPosition.toDto() = OrderPositionDto(
    amount = this.amount,
    product = ProductDto.fromDomain(this.product)
)

private fun OrderDto.toDomain(): Order = Order(
    customerId = OrderCustomerId(this.customerId!!),
    orderDate = OrderDate(this.orderDate!!),
    totalPrice = OrderPrice(this.totalPrice!!),
    positions = this.positions.map { it.toDomain() }
)

private fun OrderPositionDto.toDomain() = OrderPosition(
    amount = this.amount!!,
    product = this.product!!.toDomain()
)

