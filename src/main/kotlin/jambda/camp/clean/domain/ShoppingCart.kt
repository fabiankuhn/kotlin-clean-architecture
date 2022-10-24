package jambda.camp.clean.domain

data class ShoppingCart(
    val products: List<Product>,
    val salesperson: Salesperson
)
