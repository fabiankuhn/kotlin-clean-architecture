package jambda.camp.clean.adapter.db

import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "\"product\"")
internal data class ProductDto(
    @Id
    @NotNull
    val id: String? = null,
    @NotNull
    val name: String? = null,
    @NotNull
    val price: Double? = null
)
