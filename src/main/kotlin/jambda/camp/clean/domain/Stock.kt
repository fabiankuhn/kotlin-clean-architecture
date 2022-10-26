package jambda.camp.clean.domain

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
}

data class StockId (
    val value: String // TODO clean it up bro
)

data class StockAmount (
    val value: Long
)
