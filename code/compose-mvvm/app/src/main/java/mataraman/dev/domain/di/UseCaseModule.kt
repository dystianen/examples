package mataraman.dev.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mataraman.dev.data.repository.ExampleRepositoryImpl
import mataraman.dev.domain.usecase.ExampleUseCase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun productListUseCaseProvider(repositoryImpl: ExampleRepositoryImpl) : ExampleUseCase{
        return ExampleUseCase(repositoryImpl)
    }


}