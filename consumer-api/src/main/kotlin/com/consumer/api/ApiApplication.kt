package com.consumer.api

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@OpenAPIDefinition(
	info = Info(
		title = "GET ADDRESS - REST API",
		version = "1.0",
		description = "API para busca de endereço através de Códigos de Endereçamento Postal (CEP)"
	)
)
@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
