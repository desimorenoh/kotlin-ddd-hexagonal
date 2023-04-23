package com.codely.api.domain

interface VideoRepository {
    fun save(video: Video)
    fun search(id: VideoId): Video?
    fun all(): List<Video>
    fun latest(): Video?
}