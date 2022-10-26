package jambda.camp.clean.domain

data class CustomerId(
    val value: String
)

data class CustomerName(private val firstName: String, private val lastName: String) {

    init {
        require(firstName.isNotEmpty()) { "First name can not be empty" }
        require(lastName.isNotEmpty()) { "Last name can not be empty" }
    }
}
