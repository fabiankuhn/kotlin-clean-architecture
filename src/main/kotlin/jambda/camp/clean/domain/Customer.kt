package jambda.camp.clean.domain

data class Customer(
    override val id: UserId,
    val name: CustomerName,
    val shoppingCart: ShoppingCart
): User(id)

data class CustomerName (
    val firstName: String,
    val lastName: String
)
