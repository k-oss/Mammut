package io.github.jamiesanson.mammut.feature.instance.subfeature.feed.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingRequestHelper

private fun getErrorMessage(report: PagingRequestHelper.StatusReport): String {
    return PagingRequestHelper.RequestType.values().mapNotNull {
        report.getErrorFor(it)?.message
    }.first()
}

fun PagingRequestHelper.createStatusLiveData(): LiveData<NetworkState> {
    val liveData = MutableLiveData<NetworkState>()
    addListener { report ->
        when {
            report.hasRunning() -> liveData.postValue(NetworkState.Running)
            report.hasError() -> liveData.postValue(
                    NetworkState.Error(getErrorMessage(report)))
            else -> liveData.postValue(NetworkState.Loaded)
        }
    }
    return liveData
}