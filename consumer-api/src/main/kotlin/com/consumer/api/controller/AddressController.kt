package com.consumer.api.controller

import com.consumer.api.dto.Endereco
import com.consumer.api.service.AddressService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/search-address")
class AddressController(
    private val addressService: AddressService

) {

    private val logger = LoggerFactory.getLogger(AddressController::class.java)

    @GetMapping("/{cep}")
    fun getAddress(@PathVariable cep: String): ResponseEntity<Endereco> {
        logger.info("Request Received - CEP: $cep")
        return ResponseEntity.status(HttpStatus.OK)
            .body(addressService.getAddressByCep(cep))
    }

}