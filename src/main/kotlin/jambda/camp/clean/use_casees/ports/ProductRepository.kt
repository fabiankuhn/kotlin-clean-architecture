package jambda.camp.clean.use_casees.ports

import jambda.camp.clean.domain.Product
import jambda.camp.clean.domain.ProductId

interface ProductRepository {
    fun findById(productId: ProductId): Product
}
