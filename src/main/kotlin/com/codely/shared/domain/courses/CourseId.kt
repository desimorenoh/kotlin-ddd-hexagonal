package com.codely.shared.domain.courses

import java.util.UUID

data class CourseId(val value: String = UUID.randomUUID().toString())