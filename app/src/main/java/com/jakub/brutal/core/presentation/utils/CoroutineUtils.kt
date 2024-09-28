package com.jakub.brutal.core.presentation.utils

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun <T> ReceiveChannel<T>.receiveAsFlowOn(dispatcher: CoroutineContext): Flow<T> {
    return receiveAsFlow().flowOn(dispatcher)
}

fun CoroutineScope.safeLaunch(
    context: CoroutineContext = coroutineContext,
    onError: suspend (Throwable) -> Unit = {},
    onCancellation: suspend (Throwable) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
): Job {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        this.launch(context) {
            Log.e("CoroutineError", "safeLaunch: $throwable")
            onError(throwable)
        }
    }
    return launch(context + exceptionHandler) {
        runCatching {
            block()
        }.onFailure {
            Log.e("CoroutineError", "safeLaunch: $it")
            if (it is CancellationException) {
                onCancellation(it)
                throw it
            } else {
                onError(it)
            }
        }
    }
}
