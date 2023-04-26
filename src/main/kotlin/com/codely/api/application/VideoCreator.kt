package com.codely.api.application

import com.codely.api.domain.*
import com.codely.api.infrastructure.PublishedVideoNotifierAdapter
import org.springframework.stereotype.Component

@Component
data class VideoCreator(val repository: VideoRepository) {

    fun handle(video: Video): Video {
        val notifier: VideoNotifier = PublishedVideoNotifierAdapter()
        return video
            .also(repository::save)
            .also { notifier.notify("Video published at ${video.createdAt}") }
    }
}
