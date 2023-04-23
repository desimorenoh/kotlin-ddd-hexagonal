package com.codely.api.infrastructure

import com.codely.api.domain.Video
import com.codely.api.domain.VideoId
import com.codely.api.domain.VideoRepository
import org.springframework.stereotype.Component

@Component
class VideoRepositoryAdapter : VideoRepository {
    private var videos: MutableList<Video> = mutableListOf()

    override fun save(video: Video) {
        videos.add(video)
    }

    override fun search(id: VideoId): Video? = videos.find { it.id == id }

    override fun all(): List<Video> = videos.toList()

    override fun latest(): Video? {
        return if (videos.isNotEmpty()) {
            videos.last()
        } else {
            null
        }
    }
}