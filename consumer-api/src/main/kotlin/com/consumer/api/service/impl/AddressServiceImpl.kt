package com.consumer.api.service.impl

import com.consumer.api.client.ViaCepClient
import com.consumer.api.dto.ResponseAddress
import com.consumer.api.service.AddressService
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(
    private val viaCepClient: ViaCepClient

) : AddressService {

    override fun getAddressByCep(cep: String): ResponseAddress {
        return viaCepClient.getAddressByCep(cep)
    }
}


