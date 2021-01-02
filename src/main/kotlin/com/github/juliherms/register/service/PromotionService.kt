package com.github.juliherms.register.service

import com.github.juliherms.register.model.Promotion
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Description
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

/**
 * Class responsible to provide business rule for promotion
 */
@Component
class PromotionService {

    companion object {
        val initialPromotions = arrayOf(
                Promotion(1, "Estacionamento aos domingos",1,50.00,50.00),
                Promotion(2, "Estacionamento aos feriados",1,50.00,50.00),
        )
    }

    var promotions =  ConcurrentHashMap<Long,Promotion>(initialPromotions.associateBy( Promotion::id ))

    fun create(promotion: Promotion) {
        promotions[promotion.id] = promotion
    }

    fun getById(id: Long): Promotion? {
        return promotions[id]
    }

    fun update(id: Long, promotion:Promotion){
        promotions.remove(id)
        promotions[id] = promotion
    }

    fun remove (id: Long) {
        promotions.remove(id)
    }

    fun filter (description: String)  =
            promotions.filter {
                it.value.description.contains(description,true)
            }.map (Map.Entry<Long,Promotion>::value).toList()
}