package io.github.koss.mammut.feature.instance.presentation.state

import io.github.koss.mammut.data.models.InstanceRegistration
import io.github.koss.mammut.data.models.domain.FeedType

sealed class InstanceAction

data class OnRegistrationsLoaded(
        val registrations: List<InstanceRegistration>
) : InstanceAction()

data class OnFeedTypeChanged(
        val newFeedType: FeedType
) : InstanceAction()

data class OnOffscreenItemCountChanged(
        val newCount: Int
) : InstanceAction()