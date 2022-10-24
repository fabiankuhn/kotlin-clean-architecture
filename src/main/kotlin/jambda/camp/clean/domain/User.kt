package jambda.camp.clean.domain

abstract class User(
    open val id: UserId
)

data class UserId(
    val value: String
)
