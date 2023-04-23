package com.codely.api.application

import com.codely.api.domain.Video
import com.codely.api.domain.VideoRepository
import org.springframework.stereotype.Component

@Component
data class VideoSearcher(private val repository: VideoRepository) {
    fun all() : List<Video>? =
        repository.all()
}