package com.codely.api.domain

data class VideoUrl(val value: String) {
    init {
        require(value.isNotBlank()) { "Video url should not be blank" }
    }
}
