package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.*
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

    override fun getStock(productId: ProductId): Stock {
        return getStockDto(productId)
            .toDomain()
    }

    override fun decrementStock(productId: ProductId, amount: Long) {
        val stockDto = getStockDto(productId)

        val updatedStockDto = StockDto(
            id = stockDto.id,
            product = stockDto.product,
            amount = stockDto.amount?.minus(amount)
        )

        stockCrudRepository.save(updatedStockDto)
    }

    private fun getStockDto(productId: ProductId) = stockCrudRepository
        .findByProductId(productId.value)
        ?: throw StockNotFoundException("Stock for product id $productId not found")
}

