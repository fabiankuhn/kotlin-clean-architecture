package jambda.camp.clean.use_casees.ports

import jambda.camp.clean.domain.ProductId
import jambda.camp.clean.domain.Stock

interface StockRepository {
    fun getStock(productId: ProductId): Stock
    fun decrementStock(productId: ProductId, amount: Long)
}
