package com.shifthackz.aisdv1.app.di

import com.shifthackz.aisdv1.network.qualifiers.ApiUrlProvider
import com.shifthackz.aisdv1.app.BuildConfig
import com.shifthackz.aisdv1.core.common.schedulers.SchedulersProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.dsl.module
import java.util.concurrent.Executor
import java.util.concurrent.Executors

val providersModule = module {

    single<ApiUrlProvider> {
        object : ApiUrlProvider {
            override val stableDiffusionAutomaticApiUrl: String = BuildConfig.SERVER_URL
        }
    }

    single<SchedulersProvider> {
        object : SchedulersProvider {
            override val io: Scheduler = Schedulers.io()
            override val ui: Scheduler = AndroidSchedulers.mainThread()
            override val computation: Scheduler = Schedulers.computation()
            override val singleThread: Executor = Executors.newSingleThreadExecutor()
        }
    }
}
