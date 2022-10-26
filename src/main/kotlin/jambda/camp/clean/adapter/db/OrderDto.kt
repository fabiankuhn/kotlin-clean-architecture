package jambda.camp.clean.adapter.db

import org.jetbrains.annotations.NotNull
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "\"order\"")
internal data class OrderDto(
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
)
