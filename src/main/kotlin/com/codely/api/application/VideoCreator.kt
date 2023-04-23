package com.codely.api.application

import com.codely.api.domain.*
import com.codely.api.infrastructure.PublishedVideoNotifierAdapter
import com.codely.shared.domain.courses.CourseId
import org.springframework.stereotype.Component
import java.time.Instant

@Component
data class VideoCreator(val repository: VideoRepository) {

    fun handle(
        id: VideoId,
        type: VideoType,
        title: VideoTitle,
        url: VideoUrl,
        courseId: CourseId,
        createdAt: Instant,
    ): Video {
    val notifier: VideoNotifier = PublishedVideoNotifierAdapter()
        return Video.create(id, type, title, url, courseId, createdAt)
            .also(repository::save)
            .also { notifier.notify("Video published at $createdAt") }
    }
}