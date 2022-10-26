package jambda.camp.clean.adapter.db

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "\"order_position\"")
internal data class OrderPositionDto (
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Long? = null,
    @NotNull
    val amount: Long? = null,
    @OneToOne
    @NotNull
    val product: ProductDto? = null
)
