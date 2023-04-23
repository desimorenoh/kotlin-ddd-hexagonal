package com.codely.api.domain

import com.codely.shared.domain.courses.CourseId
import java.time.Instant

data class Video(
    val id: VideoId,
    val type: VideoType,
    val title: VideoTitle,
    val url: VideoUrl,
    val courseId: CourseId,
    val createdAt: Instant,
) {

    companion object {
        fun create(
            id: VideoId,
            type: VideoType,
            title: VideoTitle,
            url: VideoUrl,
            courseId: CourseId,
            createdAt: Instant,
        ) = Video(id, type, title, url, courseId, createdAt)
    }
}

