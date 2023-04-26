package com.codely.unitTest

import com.codely.api.application.VideoCreator
import com.codely.api.domain.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month
import java.time.ZoneOffset

class VideoCreatorTest {
    private val repository = VideoRepositoryInMemory()
    private val handler = VideoCreator(repository)

    @Test
    fun `should create a video`() {
        val newVideo: Video = aVideo(
            id = "1", createdAt = LocalDate.of(2023, Month.JANUARY, 12).atStartOfDay().toInstant(
                ZoneOffset.UTC
            )
        )

        handler.handle(newVideo)
        val saved = repository.search(VideoId("1"))

        assertThat(saved).isEqualTo(newVideo)
    }
}