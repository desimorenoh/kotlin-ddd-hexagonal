package com.codely.api.infrastructure

import com.codely.api.application.LastVideoFinder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LatestVideoFinderController
@Autowired
constructor(
    private val latestVideoFinder: LastVideoFinder
) {

    @GetMapping("/videos/last-video")
    fun getLatestVideos(): ResponseEntity<*> {
        val latestVideo = latestVideoFinder.findLastVideo()
        return when (latestVideo) {
            null -> ResponseEntity.notFound().build<Nothing>()
            else -> ResponseEntity.ok().body("Latest video is ${latestVideo.title}")
        }
    }
}