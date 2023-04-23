package com.codely.unitTest

import com.codely.api.application.VideoCreator
import com.codely.api.domain.*
import com.codely.api.infrastructure.VideoRequest
import com.codely.shared.domain.courses.CourseId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Instant

class VideoCreatorTest {
    private val repository = VideoRepositoryInMemory()
    private val handler = VideoCreator(repository)
    @Test
    fun `should create a video`() {
        val request = VideoRequest(
            type = VideoType.INTERVIEW,
            title = VideoTitle("title"),
            url = VideoUrl("url"),
            courseId = CourseId("courseId"),
        )
        val video = handler.handle(
            id = VideoId(),
            type = request.type,
            title = request.title,
            url = request.url,
            courseId = request.courseId,
            createdAt = Instant.now(),
        )
        assertThat(repository.search(video.id)).isEqualTo(video)
    }
}