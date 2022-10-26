package jambda.camp.clean.domain

data class Product(
    val id: ProductId,
    val name: ProductName,
    val price: ProductPrice
)

data class ProductName(
    val value: String
)

data class ProductPrice(
    val value: Double,
)

data class ProductId(
    val value: String
)
