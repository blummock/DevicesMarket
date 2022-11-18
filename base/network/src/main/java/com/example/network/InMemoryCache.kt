package com.example.network

import com.example.core.repo.Cache
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class InMemoryCache<T : Any>(private val timeout: Long = 60000L) : Cache<T> {

    private val safetyMutex = Mutex()
    private val expiry: Long = System.currentTimeMillis()

    private var item: T? = null

    override suspend fun getOrUpdate(supplier: suspend () -> T): T {
        if (this.item == null || System.currentTimeMillis() - expiry > timeout) {
            safetyMutex.withLock {
                this.item = supplier.invoke()
            }
        }
        return item!!
    }
}