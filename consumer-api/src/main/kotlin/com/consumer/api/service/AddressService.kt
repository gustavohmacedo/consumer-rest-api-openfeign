package com.consumer.api.service

import com.consumer.api.dto.Endereco

interface AddressService {

    fun getAddressByCep(cep: String): Endereco
}