package jambda.camp.clean.domain

data class Stock (
    val product: Product,
    val amount: StockAmount
)

data class StockAmount (
    val value: Long
)
