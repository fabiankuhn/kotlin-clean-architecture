package jambda.camp.clean.adapter.db

import jambda.camp.clean.domain.*
import jambda.camp.clean.domain.exceptions.StockNotFoundException
import jambda.camp.clean.use_casees.ports.StockRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

internal interface StockCrudRepository : CrudRepository<StockDto, Long> {
    fun findByProductId(productId: Long): StockDto?
}

@Repository
internal class StockDbRepository internal constructor(
    internal val stockCrudRepository: StockCrudRepository
) : StockRepository {

    override fun getStock(productId: ProductId): Stock {
        return (stockCrudRepository
            .findByProductId(productId.value)
            ?: throw StockNotFoundException("Stock for product id $productId not found"))
            .toDomain()
    }

    override fun updateStock(stock: Stock): Stock = stockCrudRepository
        .save(StockDto.fromDomain(stock))
        .toDomain()


}

