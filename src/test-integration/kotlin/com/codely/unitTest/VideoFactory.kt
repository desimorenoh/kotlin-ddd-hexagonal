package com.codely.unitTest

import com.codely.api.domain.*
import com.codely.api.domain.VideoType.*
import com.codely.shared.domain.courses.CourseId
import java.time.Instant
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneOffset

fun aVideo(
    id: String = "07c206d5-7286-4a46-8339-5dee525a78d7",
    type: VideoType = INTERVIEW,
    title: String = "Video title",
    url: String = "https://www.youtube.com/watch?v=1",
    courseId: String = "1",
    createdAt: Instant = LocalDateTime.of(2022, Month.JANUARY, 10, 6, 15).toInstant(ZoneOffset.UTC),
) = Video(VideoId(id), type, VideoTitle(title), VideoUrl(url), CourseId(courseId), createdAt)
