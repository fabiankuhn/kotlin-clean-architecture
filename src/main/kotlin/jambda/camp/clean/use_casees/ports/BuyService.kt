package jambda.camp.clean.use_casees.ports

import jambda.camp.clean.domain.*

interface BuyService {

    fun buy(customerId: CustomerId, productIds: List<ProductId>): Order

}
