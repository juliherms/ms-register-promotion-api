package com.github.juliherms.register.controller

import com.github.juliherms.register.model.Promotion
import com.github.juliherms.register.service.PromotionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * This class responsible to provide promotions endpoint
 */
@RestController
@RequestMapping(value = ["/promotions"])
class PromotionsController {

    @Autowired
    lateinit var service: PromotionService

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Promotion? {
        return service.getById(id)
     }

    @PostMapping()
    fun create(@RequestBody promotion: Promotion) {
        service.create(promotion)
    }

    @DeleteMapping("/{id}")
    fun delete (@PathVariable id: Long) {
        service.remove(id)
    }

    @PutMapping("/{id}")
    fun update (@PathVariable id:Long, @RequestBody promotion:Promotion) {
        service.update(id,promotion)
    }

    @GetMapping("")
    fun listAll(@RequestParam(required = false, defaultValue = "") description: String) =
        service.filter(description)

}