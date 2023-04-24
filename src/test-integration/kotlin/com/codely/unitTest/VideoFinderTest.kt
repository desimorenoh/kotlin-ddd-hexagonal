package com.codely.unitTest

import com.codely.api.domain.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VideoFinderTest {
    private val repository = VideoRepositoryInMemory()

    @Test
    fun `should find a video`() {
        val id = aVideo("1")
        repository.save(aVideo(id.id.value))

        val result = repository.search(VideoId("1"))

        assertThat(id).isEqualTo(result)
    }
}