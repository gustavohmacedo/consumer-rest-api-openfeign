package com.consumer.api.dto

data class ResponseAddress(
    val cep: String,
    val logradouro: String,
    val complemento: String?,
    val bairro: String,
    val localidade: String,
    val uf: String

)
