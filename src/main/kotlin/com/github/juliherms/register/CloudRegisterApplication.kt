package com.github.juliherms.register

import com.github.juliherms.register.model.Promotion
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class CloudRegisterApplication

	fun main(args: Array<String>) {
		runApplication<CloudRegisterApplication>(*args)
	}
