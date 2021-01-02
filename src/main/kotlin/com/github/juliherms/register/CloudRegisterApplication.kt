package com.github.juliherms.register

import com.github.juliherms.register.model.Promotion
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class CloudRegisterApplication {

	companion object {
		val initialPromotions = arrayOf(
				Promotion(1, "Estacionamento aos domingos",1,50.00,50.00),
				Promotion(2, "Estacionamento aos feriados",1,50.00,50.00),
		)
	}

	@Bean
	fun promotions(): ConcurrentHashMap<Long,Promotion> {
		return ConcurrentHashMap<Long,Promotion>(initialPromotions.associateBy( Promotion::id ))
	}
}

fun main(args: Array<String>) {
	runApplication<CloudRegisterApplication>(*args)
}
