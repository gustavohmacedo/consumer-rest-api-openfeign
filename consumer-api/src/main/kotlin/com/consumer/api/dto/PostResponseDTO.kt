package com.consumer.api.dto

data class PostResponseDTO(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)
