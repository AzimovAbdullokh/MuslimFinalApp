package com.example.common_api

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProviderInCommonApi {

    fun main(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun default(): CoroutineDispatcher

    fun unconfined(): CoroutineDispatcher
}