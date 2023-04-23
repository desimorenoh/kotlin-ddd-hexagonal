package com.codely.api.infrastructure

import com.codely.api.application.VideoCreator
import com.codely.api.domain.*
import com.codely.shared.domain.courses.CourseId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

data class VideoRequest(
    val type: VideoType,
    val title: VideoTitle,
    val url: VideoUrl,
    val courseId: CourseId,
)


data class VideoResponse(
    val id: VideoId,
    val type: VideoType,
    val title: VideoTitle,
    val url: VideoUrl,
    val courseId: CourseId,
    val createdAt: Instant,
    val message: String,
) {
    companion object {
        fun fromVideo(video: Video, message: String): VideoResponse {
            return VideoResponse(
                id = video.id,
                type = video.type,
                title = video.title,
                url = video.url,
                courseId = video.courseId,
                createdAt = video.createdAt,
                message = message
            )
        }
    }
}



@RestController
class VideoCreatorController
@Autowired
constructor(
    private val handler: VideoCreator,
    private val notifier: VideoNotifier,
    ) {
    @PostMapping("/videos/create")
    fun createVideo(@RequestBody request: VideoRequest): ResponseEntity<VideoResponse> {
       val video = handler.handle(
            id = VideoId(),
            type = request.type,
            title = request.title,
            url = request.url,
            courseId = request.courseId,
            createdAt = Instant.now(),

        )
        val message = "Video published at ${Instant.now()}"
        notifier.notify(message)
        return ResponseEntity.ok().body(VideoResponse.fromVideo(video, message))
    }
}