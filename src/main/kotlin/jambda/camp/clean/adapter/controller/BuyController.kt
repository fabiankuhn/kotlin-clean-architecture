package jambda.camp.clean.adapter.controller

import jambda.camp.clean.domain.*
import jambda.camp.clean.use_casees.BuyUC
import jambda.camp.clean.use_casees.ports.OrderRepository
import jambda.camp.clean.use_casees.ports.ProductRepository
import jambda.camp.clean.use_casees.ports.StockRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BuyController(
    val stockRepository: StockRepository,
    val productRepository: ProductRepository,
    val orderRepository: OrderRepository
) {
    val buyUC = BuyUC()

    @PostMapping
    private fun buy(orderRequestDto: OrderRequestDto): OrderDto {
        val order = buyUC.buy(
            stockRepository = stockRepository,
            orderRepository = orderRepository,
            productRepository = productRepository,
            customerId = CustomerId(orderRequestDto.customerId),
            productIds = orderRequestDto.productIds.map { ProductId(it) }
        )

        return OrderDto.fromDomain(order)
    }
}
