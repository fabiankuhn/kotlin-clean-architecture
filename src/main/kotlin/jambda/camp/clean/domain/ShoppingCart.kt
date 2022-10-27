package jambda.camp.clean.domain

data class ShoppingCart(
    val items: List<ShoppingCartPosition>
) {
    fun getTotalPrice(): Double = items.sumOf { it.product.price.value * it.amount }

    companion object {
        fun fromProducts(products: List<Product> ): ShoppingCart {
            val items = products
                .groupingBy { it }
                .eachCount()
                .map { ShoppingCartPosition(it.value.toLong(), it.key) }
            return ShoppingCart(items)
        }
    }
}

data class ShoppingCartPosition(
    val amount: Long,
    val product: Product
)
