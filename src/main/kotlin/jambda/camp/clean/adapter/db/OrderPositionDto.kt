package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.OrderPosition
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "\"order_position\"")
internal class OrderPositionDto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @NotNull
    val amount: Long? = null,
    @OneToOne
    @NotNull
    val product: ProductDto? = null
) {

    fun toDomain() = OrderPosition(
        amount = amount!!,
        product = product!!.toDomain()
    )

    companion object {
        fun fromDomain(orderPositionDto: OrderPosition) = OrderPositionDto(
            amount = orderPositionDto.amount,
            product = ProductDto.fromDomain(orderPositionDto.product)
        )
    }
}
