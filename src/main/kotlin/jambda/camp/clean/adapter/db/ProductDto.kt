package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.Product
import jambda.camp.clean.domain.ProductId
import jambda.camp.clean.domain.ProductName
import jambda.camp.clean.domain.ProductPrice
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "\"product\"")
internal data class ProductDto(
    @Id
    @NotNull
    val id: Long? = null,
    @NotNull
    val name: String? = null,
    @NotNull
    val price: Double? = null
) {

    fun toDomain(): Product = Product(
        id = ProductId(this.id!!),
        name = ProductName(this.name!!),
        price = ProductPrice(this.price!!)
    )

    companion object {
        fun fromDomain(product: Product): ProductDto = ProductDto(
            id = product.id.value,
            name = product.name.value,
            price = product.price.value
        )
    }
}
