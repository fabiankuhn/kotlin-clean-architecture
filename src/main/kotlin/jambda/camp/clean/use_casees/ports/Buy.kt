package jambda.camp.clean.use_casees.ports

import jambda.camp.clean.domain.*

interface Buy {
    fun buy(
        customerId: CustomerId,
        productIds: List<ProductId>,
        stockRepository: StockRepository,
        productRepository: ProductRepository,
        orderRepository: OrderRepository
    ): Order
}
