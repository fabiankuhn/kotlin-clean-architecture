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
    stockRepository: StockRepository,
    productRepository: ProductRepository,
    orderRepository: OrderRepository
) {
    val buyService = BuyUC(
        stockRepository = stockRepository,
        orderRepository =  orderRepository,
        productRepository =  productRepository
    )

    @PostMapping
    private fun buy(orderRequestDto: OrderRequestDto): OrderDto {
        val order = buyService.buy(
            CustomerId(orderRequestDto.customerId),
            orderRequestDto.productIds.map { ProductId(it) }
        )

        return OrderDto.fromDomain(order)
    }
}
