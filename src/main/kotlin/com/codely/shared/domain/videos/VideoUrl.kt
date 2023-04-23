package com.codely.shared.domain.videos

import com.codely.shared.domain.valueObject.StringValueObject
import java.net.MalformedURLException
import java.net.URL

class VideoUrl(value: String) : StringValueObject(value) {
    init {
        ensureIsValidUrl(value)
    }

    private fun ensureIsValidUrl(url: String) {
        try {
            URL(url)
        } catch (e: MalformedURLException) {
            throw IllegalArgumentException("The url <$url> is not well formatted")
        }
    }
}