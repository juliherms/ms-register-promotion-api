package com.github.juliherms.register

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CloudRegisterApplication

fun main(args: Array<String>) {
	runApplication<CloudRegisterApplication>(*args)
}
