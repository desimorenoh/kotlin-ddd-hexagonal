package com.codely.unitTest

import com.codely.api.domain.Video
import com.codely.api.domain.VideoId
import com.codely.api.domain.VideoRepository

class VideoRepositoryInMemory: VideoRepository {
    private val videoMap = mutableMapOf<String, Video>()
    override fun save(video: Video) {
        videoMap[video.id.value] = video
    }

    override fun search(id: VideoId): Video? {
        return videoMap[id.value]
    }

    override fun all(): List<Video> {
        return videoMap.values.toList()
    }

    override fun latest(): Video? {
        return videoMap.values.maxByOrNull { it.createdAt }
    }
}