package com.ranjan.myportfolio.presentation.util

import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.launch

fun Modifier.forwardScrollTo(
    state: LazyListState,
): Modifier = composed {
    val scope = rememberCoroutineScope()

    pointerInput(state) {
        awaitPointerEventScope {
            while (true) {
                val delta = awaitPointerEvent()
                    .changes
                    .firstOrNull()
                    ?.scrollDelta
                    ?.y
                    ?.takeIf { it != 0f }
                    ?: continue

                scope.launch { state.scrollBy(delta) }
            }
        }
    }
}