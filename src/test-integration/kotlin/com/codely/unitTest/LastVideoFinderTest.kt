package com.codely.unitTest

import com.codely.api.application.LastVideoFinder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LastVideoFinderTest {

    @Test
    fun `should find the last video`() {
        val repository = VideoRepositoryInMemory()
        val handler = LastVideoFinder(repository)

        repository.save(aVideo("1"))
        repository.save(aVideo("2"))
        repository.save(aVideo("3"))

        val result = handler.findLastVideo()

        assertThat(result?.createdAt).isEqualTo(aVideo("3")?.createdAt)


    }
}