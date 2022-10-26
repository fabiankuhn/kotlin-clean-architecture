package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.ProductId
import jambda.camp.clean.domain.exceptions.StockNotFoundException
import jambda.camp.clean.use_casees.ports.StockRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

internal interface StockCrudRepository : CrudRepository<StockDto, String> {
    fun findByProductId(productId: String): StockDto?
}

@Repository
internal class StockDbRepository internal constructor(
    private val stockCrudRepository: StockCrudRepository
) : StockRepository {

    override fun getProductAmount(productId: ProductId): Long {
        return stockCrudRepository
            .findByProductId(productId.value)
                ?.amount
            ?: throw StockNotFoundException("Stock for product id $productId not found")
    }

    override fun removeStock(productId: ProductId, amount: Long) {
        val stock = stockCrudRepository
            .findByProductId(productId.value)
            ?: throw StockNotFoundException("Stock for product id $productId not found")

        val updatedStock = StockDto(
            id = stock.id,
            product = stock.product,
            amount = stock.amount?.minus(1)
        )

        stockCrudRepository.save(updatedStock)
    }

}
