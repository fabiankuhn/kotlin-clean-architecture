package jambda.camp.clean.use_casees

import jambda.camp.clean.domain.*
import jambda.camp.clean.use_casees.ports.Buy
import jambda.camp.clean.use_casees.ports.OrderRepository
import jambda.camp.clean.use_casees.ports.ProductRepository
import jambda.camp.clean.use_casees.ports.StockRepository
import java.time.Instant

class BuyUC : Buy {

    override fun buy(
        customerId: CustomerId,
        productIds: List<ProductId>,
        stockRepository: StockRepository,
        productRepository: ProductRepository,
        orderRepository: OrderRepository
    ): Order {

        val products = productIds.map { productRepository.findById(it) }
        val shoppingCart = ShoppingCart.fromProducts(products)

        shoppingCart.items
            .map { position ->
                val stock = stockRepository.getStock(position.product.id)
                stock.verifyAvailable(position.amount)
                stock.decrement(position.amount)
            }
            .forEach { stockRepository.updateStock(it) }

        val order = createOrder(shoppingCart, customerId)
        return orderRepository.save(order)
    }

    private fun createOrder(
        shoppingCart: ShoppingCart,
        customerId: CustomerId
    ): Order = Order(
        orderDate = OrderDate(
            value = Instant.now()
        ),
        totalPrice = OrderPrice(
            value = shoppingCart.getTotalPrice()
        ),
        customerId = OrderCustomerId(customerId.value),
        positions = shoppingCart.items.map {
            OrderPosition(
                amount = it.amount,
                product = it.product
            )
        }
    )
}
