package com.codely.api.infrastructure

import com.codely.api.application.VideoFinder
import com.codely.api.domain.VideoId
import com.codely.api.domain.VideoTitle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class VideoFinderController
@Autowired
constructor(
    private val videoFinder: VideoFinder
) {

    @GetMapping("/videos/{id}")
    fun getVideos(@PathVariable id: VideoId): ResponseEntity<*> {
        val video = videoFinder.find(id)
        return when (video) {
            null -> ResponseEntity.notFound().build<Nothing>()
            else -> ResponseEntity.ok().body("Video ${video.title.value} found")
        }
    }
}