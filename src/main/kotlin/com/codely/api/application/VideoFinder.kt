package com.codely.api.application

import com.codely.api.domain.Video
import com.codely.api.domain.VideoId
import com.codely.api.domain.VideoRepository
import org.springframework.stereotype.Component

@Component
data class VideoFinder(val repository: VideoRepository) {
    fun find(id: VideoId): Video? =
        repository.search(id)
}