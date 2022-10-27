package jambda.camp.clean.domain

import jambda.camp.clean.domain.exceptions.ProductNotAvailableException

data class Stock (
    val id: StockId,
    val product: Product,
    val amount: StockAmount
) {
    fun decrement(decrementAmount: Long) = Stock(
        id = id,
        product = product,
        amount = StockAmount(amount.value - decrementAmount)
    )
    fun verifyAvailable(requestedAmount: Long){
        if (amount.value < requestedAmount) {
            throw ProductNotAvailableException("Product ${product.name} is not available")
        }
    }
}

data class StockId (
    val value: Long
)

data class StockAmount (
    val value: Long
)
