package jambda.camp.clean.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ShoppingCartTest {

    @Test
    fun `should group products to a shopping cart`() {

        val cart = ShoppingCart.fromProducts(
            listOf(
                Product(
                    id = ProductId("1"),
                    name = ProductName("Apfel"),
                    price = ProductPrice(4.0)
                ),
                Product(
                    id = ProductId("1"),
                    name = ProductName("Apfel"),
                    price = ProductPrice(4.0)
                )
            )
        )

        assertThat(cart).isEqualTo(
            ShoppingCart(listOf(
                ShoppingCartPosition(
                    amount = 2,
                    product = Product(
                        id = ProductId("1"),
                        name = ProductName("Apfel"),
                        price = ProductPrice(4.0)
                    )
                )
            ))
        )

    }

}
