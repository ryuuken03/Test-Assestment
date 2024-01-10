package mapan.developer.testassesment.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mapan.developer.testassesment.domain.repository.Repository
import mapan.developer.testassesment.domain.usecase.GetDocuments
import javax.inject.Singleton

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetDocuments(repository: Repository): GetDocuments =
        GetDocuments(repository)
}