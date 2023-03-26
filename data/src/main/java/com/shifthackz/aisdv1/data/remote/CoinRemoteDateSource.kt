package com.shifthackz.aisdv1.data.remote

import com.shifthackz.aisdv1.domain.datasource.CoinDataSource
import com.shifthackz.aisdv1.network.api.StableDiffusionCoinsRestApi
import io.reactivex.rxjava3.core.Single

internal class CoinRemoteDateSource(
    private val api: StableDiffusionCoinsRestApi,
) : CoinDataSource.Remote {

    override fun fetchCoinsConfig(): Single<Int> = api
        .fetchCoinsConfig()
        .map { response -> response.coinsPerDay ?: 10 }
        .onErrorReturn { 10 }
}
