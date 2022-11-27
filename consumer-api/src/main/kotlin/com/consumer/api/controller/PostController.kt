package com.consumer.api.controller

import com.consumer.api.client.PostClient
import com.consumer.api.dto.PostResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/posts")
class PostController(
    private val postClient: PostClient,
) {
    @GetMapping
    fun getPost(): ResponseEntity<List<PostResponseDTO>> {
        return ResponseEntity
            .status(HttpStatus.OK).body(postClient.gePosts())

    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Int): ResponseEntity<PostResponseDTO> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(postClient.getPostById(id))
    }

}