package com.codely.integration.VideoRepositoryIntegrationTest

import com.codely.api.domain.*
import com.codely.shared.Application
import com.codely.shared.domain.courses.CourseId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.Instant

@SpringBootTest(classes = [Application::class])
class VideoRepositoryAdapterTest {
    @Autowired
    private lateinit var repository: VideoRepository

    @Test
    fun `should save and retrieve videos`() {
        val video1 = Video.create(
            id = VideoId(),
            type = VideoType.INTERVIEW,
            title = VideoTitle("Video 1"),
            url = VideoUrl("https://www.youtube.com/watch?v=123"),
            courseId = CourseId("Course 1"),
            createdAt = Instant.now()
        )

        val video2 = Video.create(
            id = VideoId(),
            type = VideoType.INTERVIEW,
            title = VideoTitle("Video 2"),
            url = VideoUrl("https://www.youtube.com/watch?v=456"),
            courseId = CourseId("Course 2"),
            createdAt = Instant.now().plusSeconds(60)
        )

        repository.save(video1)
        repository.save(video2)

        assertThat(repository.search(video1.id)).isEqualTo(video1)
        assertThat(repository.search(video2.id)).isEqualTo(video2)
        assertThat(repository.all()).containsExactlyInAnyOrder(video1, video2)
        assertThat(repository.latest()).isEqualTo(video2)
    }

}