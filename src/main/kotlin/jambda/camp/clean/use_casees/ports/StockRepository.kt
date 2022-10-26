package jambda.camp.clean.use_casees.ports

import jambda.camp.clean.domain.ProductId

interface StockRepository {
    fun getProductAmount(productId: ProductId): Long
    fun removeStock(productId: ProductId, amount: Long)
}
