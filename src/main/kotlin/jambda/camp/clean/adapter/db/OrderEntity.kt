package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.Order
import jambda.camp.clean.domain.OrderCustomerId
import jambda.camp.clean.domain.OrderDate
import jambda.camp.clean.domain.OrderPrice
import org.jetbrains.annotations.NotNull
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "\"order\"")
internal data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @NotNull
    val customerId: String? = null,
    @NotNull
    val orderDate: Instant? = null,
    @NotNull
    val totalPrice: Double? = null,
    @OneToMany(cascade = [ CascadeType.ALL ])
    @JoinColumn(name = "ORDER_ID")
    @NotNull
    val positions: List<OrderPositionDto> = emptyList()
) {

    fun toDomain() = Order(
        customerId = OrderCustomerId(this.customerId!!),
        orderDate = OrderDate(this.orderDate!!),
        totalPrice = OrderPrice(this.totalPrice!!),
        positions = this.positions.map { it.toDomain() }
    )

    companion object {
        fun fromDomain(order: Order) = OrderEntity(
            customerId = order.customerId.value,
            orderDate = order.orderDate.value,
            totalPrice = order.totalPrice.value,
            positions = order.positions.map { OrderPositionDto.fromDomain(it) }
        )

    }
}
