package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.Stock
import jambda.camp.clean.domain.StockAmount
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "\"stock\"")
internal data class StockDto(
    @Id
    @NotNull
    val id: String? = null,
    @OneToOne
    @NotNull
    val product: ProductDto? = null,
    var amount: Long? = 0

) {

    fun toDomain() = Stock(
        product = this.product!!.toDomain(),
        amount = StockAmount(this.amount!!)
    )
}

