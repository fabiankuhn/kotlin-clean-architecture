package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.Stock
import jambda.camp.clean.domain.StockAmount
import jambda.camp.clean.domain.StockId
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "\"stock\"")
internal class StockDto(
    @Id
    @NotNull
    val id: String? = null,
    @OneToOne
    @NotNull
    val product: ProductDto? = null,
    var amount: Long? = 0

) {

    fun toDomain() = Stock(
        id = StockId(id!!),
        product = product!!.toDomain(), // TODO remove this
        amount = StockAmount(amount!!)
    )

    companion object {
        fun fromDomain(stock: Stock): StockDto = StockDto(
            id = stock.id.value,
            product = ProductDto.fromDomain(stock.product),
            amount = stock.amount.value
        )
    }
}

