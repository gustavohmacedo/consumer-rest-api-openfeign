package com.consumer.api.client

import com.consumer.api.dto.ResponseAddress
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "viaCep", url = "\${endpoints.viacep.url}")
interface ViaCepClient {

    @GetMapping(path = ["/{cep}/json"], consumes = [APPLICATION_JSON_VALUE])
    fun getAddressByCep(@PathVariable("cep") cep: String): ResponseAddress

}