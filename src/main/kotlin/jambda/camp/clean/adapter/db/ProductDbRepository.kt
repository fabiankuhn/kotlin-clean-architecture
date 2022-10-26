package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.Product
import jambda.camp.clean.domain.ProductId
import jambda.camp.clean.domain.ProductName
import jambda.camp.clean.domain.ProductPrice
import jambda.camp.clean.domain.exceptions.ProductNotFoundException
import jambda.camp.clean.use_casees.ports.ProductRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

internal interface ProductCrudRepository : CrudRepository<ProductDto, String>

@Repository
internal class ProductDbRepository internal constructor(
    private val productRepository: ProductCrudRepository
) : ProductRepository {

    override fun findById(productId: ProductId): Product = productRepository
        .findById(productId.value)
        .orElseThrow { ProductNotFoundException("Product with id ${productId.value} not found") }
        .toDomain()
}

private fun ProductDto.toDomain(): Product { // TODO maybe centralize
    return Product(
        id = ProductId(this.id!!),
        name = ProductName(this.name!!),
        price = ProductPrice(this.price!!)
    )
}