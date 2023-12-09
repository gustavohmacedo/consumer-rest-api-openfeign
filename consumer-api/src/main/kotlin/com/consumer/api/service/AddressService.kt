package com.consumer.api.service

import com.consumer.api.dto.ResponseAddress

interface AddressService {

    fun getAddressByCep(cep: String): ResponseAddress
}