package com.github.juliherms.register.controller

import com.github.juliherms.register.model.Promotion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap


/**
 * This class responsible to provide promotions endpoint
 */
@RestController
@RequestMapping(value = ["/promotions"])
class PromotionsController {

    @Autowired
    lateinit var promotions: ConcurrentHashMap<Long,Promotion>

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Promotion? {
        return promotions[id]
     }

    @PostMapping()
    fun create(@RequestBody promotion: Promotion) {
        promotions[promotion.id] = promotion
    }

    @DeleteMapping("/{id}")
    fun delete (@PathVariable id: Long) {
        promotions.remove(id);
    }

    @PutMapping("/{id}")
    fun update (@PathVariable id:Long, @RequestBody promotion:Promotion) {
        promotions.remove(id)
        promotions[id] = promotion
    }

    @GetMapping("")
    fun listAll(@RequestParam(required = false, defaultValue = "") description: String) =

        promotions.filter {
            it.value.description.contains(description,true)
        }.map (Map.Entry<Long,Promotion>::value).toList()
}