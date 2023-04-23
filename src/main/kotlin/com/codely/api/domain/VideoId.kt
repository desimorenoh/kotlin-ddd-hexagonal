package com.codely.api.domain

import java.util.UUID

data class VideoId(val value: String = UUID.randomUUID().toString())

