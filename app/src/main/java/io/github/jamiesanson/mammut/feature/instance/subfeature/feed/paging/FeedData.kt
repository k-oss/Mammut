package io.github.jamiesanson.mammut.feature.instance.subfeature.feed.paging

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import io.github.jamiesanson.mammut.feature.base.Event

data class FeedData<T>(
        // the LiveData of paged lists for the UI to observe
        val pagedList: LiveData<PagedList<T>>,

        val itemStreamed: LiveData<Event<Unit?>>,
        // represents the network request status to show to the user
        val networkState: LiveData<NetworkState>,
        // represents the refresh status to show to the user. Separate from networkState, this
        // value is importantly only when refresh is requested.
        val refreshState: LiveData<NetworkState>,
        // refreshes the whole data and fetches it from scratch.
        val refresh: () -> Unit,
        // retries any failed requests.
        val retry: () -> Unit)