package jambda.camp.clean.domain

data class Customer(
    override val id: UserId,
    val name: CustomerName,
    val shoppingCart: ShoppingCart
): User(id)

data class CustomerName(private val firstName: String, private val lastName: String) {

    init {
        require(firstName.isNotEmpty()) { "First name can not be empty" }
        require(lastName.isNotEmpty()) { "Last name can not be empty" }
    }
}
