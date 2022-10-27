package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.Stock
import jambda.camp.clean.domain.StockAmount
import jambda.camp.clean.domain.StockId
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.MapsId
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "\"stock\"")
internal data class StockDto(

    @Id
    @NotNull
    val id: Long? = null,

    @MapsId
    @OneToOne
    @NotNull
    val product: ProductDto? = null,
    var amount: Long? = 0
) {

    fun toDomain() = Stock(
        id = StockId(id!!),
        product = product!!.toDomain(),
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

