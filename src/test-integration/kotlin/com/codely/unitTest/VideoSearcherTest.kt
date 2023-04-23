package com.codely.unitTest

import com.codely.api.application.VideoSearcher
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VideoSearcherTest {
    @Test
    fun `should find all videos`() {
        val repository = VideoRepositoryInMemory()
        val handler = VideoSearcher(repository)

        repository.save(aVideo("1"))
        repository.save(aVideo("2"))
        repository.save(aVideo("3"))

        val result = handler.all()

        assertThat(result).isEqualTo(listOf(aVideo("1"), aVideo("2"), aVideo("3")))
    }
}