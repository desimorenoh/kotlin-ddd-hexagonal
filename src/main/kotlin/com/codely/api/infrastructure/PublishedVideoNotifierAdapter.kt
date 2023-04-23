package com.codely.api.infrastructure

import com.codely.api.domain.VideoNotifier
import org.springframework.stereotype.Service

@Service
class PublishedVideoNotifierAdapter : VideoNotifier {
    override fun notify(message: String) {
    }
}