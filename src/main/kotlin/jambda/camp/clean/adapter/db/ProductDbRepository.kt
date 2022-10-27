package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.Product
import jambda.camp.clean.domain.ProductId
import jambda.camp.clean.domain.exceptions.ProductNotFoundException
import jambda.camp.clean.use_casees.ports.ProductRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

internal interface ProductCrudRepository : CrudRepository<ProductEntity, Long>

@Repository
internal class ProductDbRepository internal constructor(
    private val productRepository: ProductCrudRepository
) : ProductRepository {

    override fun findById(productId: ProductId): Product = productRepository
        .findById(productId.value)
        .orElseThrow { ProductNotFoundException("Product with id ${productId.value} not found") }
        .toDomain()
}
