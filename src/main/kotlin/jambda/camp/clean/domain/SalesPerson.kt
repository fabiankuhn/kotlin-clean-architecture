package jambda.camp.clean.domain

data class Salesperson (
    override val id: UserId,
    val firm: SalesPersonFirm,
    val stock: Stock
): User(id)

data class SalesPersonFirm(
    val name: String
)
