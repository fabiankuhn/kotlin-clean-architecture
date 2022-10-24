package jambda.camp.clean.domain

data class Product(
    val name: ProductName,
    val price: ProductPrice
)

data class ProductName(
    val value: String
)

data class ProductPrice(
    val amount: Double,
)
