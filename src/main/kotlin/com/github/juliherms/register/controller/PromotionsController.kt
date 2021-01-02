package com.github.juliherms.register.controller

import com.github.juliherms.register.model.Promotion
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


/**
 * This class responsible to provide promotions endpoint
 */
@RestController
class PromotionsController {

    @RequestMapping(value = ["/sayHello"], method = arrayOf(RequestMethod.GET))
    fun sayHello(): String {
        return "Hello World";
    }

    @RequestMapping(value = ["/promotions"], method = arrayOf(RequestMethod.GET))
    fun getPromotion(): Promotion{

        var promotion = Promotion(id = 1L, description = "teste", quantityDays = 7, 10.00, percentualDiscount = 10.00 )
        return promotion
    }


}