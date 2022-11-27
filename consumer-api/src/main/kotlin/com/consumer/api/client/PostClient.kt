package com.consumer.api.client

import com.consumer.api.dto.PostResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "post", url = "https://jsonplaceholder.typicode.com")
interface PostClient {

    @GetMapping("/posts")
    fun gePosts(): List<PostResponseDTO>

    @GetMapping("/posts/{id}")
    fun getPostById(@PathVariable id: Int): PostResponseDTO

}