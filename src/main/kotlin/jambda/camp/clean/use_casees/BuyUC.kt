package jambda.camp.clean.use_casees

import jambda.camp.clean.domain.*
import jambda.camp.clean.domain.exceptions.ProductNotAvailableException
import jambda.camp.clean.use_casees.ports.BuyService
import jambda.camp.clean.use_casees.ports.OrderRepository
import jambda.camp.clean.use_casees.ports.ProductRepository
import jambda.camp.clean.use_casees.ports.StockRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class BuyUC(
    private val stockRepository: StockRepository,
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository
) : BuyService {

    override fun buy(customerId: CustomerId, productIds: List<ProductId>): Order {

        val products = productIds.map { productRepository.findById(it) }
        val shoppingCart = ShoppingCart.fromProducts(products)

        shoppingCart.items.map {
            val stock = stockRepository.getStock(it.product.id)
            if (stock.amount.value < it.amount) {
                throw ProductNotAvailableException("Product ${it.product.name} is not available")
            }
            stock.decrement(it.amount)
        }.forEach {
            stockRepository.updateStock(it)
        }

        val sum = shoppingCart.getTotalPrice()

        val order = Order(
            orderDate = OrderDate(value = Instant.now()),
            totalPrice = OrderPrice(value = sum),
            customerId = OrderCustomerId(customerId.value),
            positions = shoppingCart.items.map {
                OrderPosition(
                    amount = it.amount,
                    product = it.product
                )
            }
        )

        return orderRepository.save(order)
    }
}
