package com.shifthackz.aisdv1.domain.usecase

import com.shifthackz.aisdv1.domain.repository.ServerConfigurationRepository
import com.shifthackz.aisdv1.domain.repository.StableDiffusionModelsRepository
import com.shifthackz.aisdv1.domain.repository.StableDiffusionSamplersRepository
import io.reactivex.rxjava3.core.Completable

class DataPreLoaderUseCaseImpl(
    private val serverConfigurationRepository: ServerConfigurationRepository,
    private val sdModelsRepository: StableDiffusionModelsRepository,
    private val sdSamplersRepository: StableDiffusionSamplersRepository,
) : DataPreLoaderUseCase {

    override fun execute(): Completable = serverConfigurationRepository.fetchConfiguration()
        .andThen(sdModelsRepository.fetchModels())
        .andThen(sdSamplersRepository.fetchSamplers())
}
