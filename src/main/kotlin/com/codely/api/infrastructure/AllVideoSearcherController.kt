package com.codely.api.infrastructure

import com.codely.api.application.VideoSearcher
import com.codely.api.domain.Video
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AllVideoSearcherController
@Autowired
constructor(
    private val videoSearcher: VideoSearcher
) {

    @GetMapping("/videos")
    fun getVideos(): ResponseEntity<*> {
        val listOfVideos = videoSearcher.all()
        return when (listOfVideos) {
            null -> ResponseEntity.notFound().build<Nothing>()
            else -> ResponseEntity.ok().body(listOfVideos)
        }
    }
}