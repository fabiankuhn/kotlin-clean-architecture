package jambda.camp.clean.adapter.controller

import jambda.camp.clean.domain.*
import jambda.camp.clean.use_casees.ports.BuyService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BuyController(val buyService: BuyService) {

    @PostMapping
    private fun buy(orderRequest: OrderRequest): OrderDto = buyService.buy(
        CustomerId(orderRequest.customerId),
        orderRequest.productIds.map { ProductId(it) }
    ).toDto()
}

private fun Order.toDto(): OrderDto = OrderDto(
    orderDate = this.orderDate.value,
    totalPrice = this.totalPrice.value,
    orderPosition = this.positions.map { it.toDto() }
)

private fun OrderPosition.toDto() = OrderPositionDto (
    amount = this.amount,
    productName = this.product.name.value
)
