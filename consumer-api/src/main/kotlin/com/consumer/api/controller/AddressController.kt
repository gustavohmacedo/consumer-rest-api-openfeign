package com.consumer.api.controller

import com.consumer.api.dto.ResponseAddress
import com.consumer.api.service.AddressService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/search-address")
@Tag(name = "GET ADDRESS - REST API")
class AddressController(
    private val addressService: AddressService

) {

    private val logger = LoggerFactory.getLogger(AddressController::class.java)

    @Operation(summary = "Busca endereço por CEP", method = "GET")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Endereço retornado com sucesso"),
            ApiResponse(responseCode = "400", description = "CEP informado é inválido"),
            ApiResponse(responseCode = "500", description = "Erro interno no servidor")
        ]
    )
    @GetMapping("/{cep}")
    fun getAddress(
        @PathVariable cep: String
    ): ResponseEntity<ResponseAddress> {

        logger.info("Request Received - CEP: $cep")

        return try {
            return ResponseEntity(
                addressService.getAddressByCep(cep),
                HttpStatus.OK
            ).also {
                logger.info("Address returned successfully")
            }
        } catch (ex: Exception) {
            logger.error("ADDRESS SEARCH ERROR - CEP: $cep", ex)
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }

    }

}