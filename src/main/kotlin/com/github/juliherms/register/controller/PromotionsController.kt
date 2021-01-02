package com.github.juliherms.register.controller

import com.github.juliherms.register.model.Promotion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap


/**
 * This class responsible to provide promotions endpoint
 */
@RestController
class PromotionsController {

    @Autowired
    lateinit var promotions: ConcurrentHashMap<Long,Promotion>

    @RequestMapping(value = ["/sayHello"], method = arrayOf(RequestMethod.GET))
    fun sayHello(): String {
        return "Hello World";
    }

    @RequestMapping(value = ["/promotions/{id}"], method = arrayOf(RequestMethod.GET))
    fun getById(@PathVariable id: Long): Promotion? {
        return promotions[id]
     }

    @RequestMapping(value = ["/promotions"], method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody promotion: Promotion) {
        promotions[promotion.id] = promotion
    }

    @RequestMapping(value = ["/promotions/{id}"], method = arrayOf(RequestMethod.DELETE))
    fun delete (@PathVariable id: Long) {
        promotions.remove(id);
    }
}